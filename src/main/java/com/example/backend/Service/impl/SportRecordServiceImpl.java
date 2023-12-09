package com.example.backend.Service.impl;

import com.example.backend.Dao.SportRecordDao;
import com.example.backend.Service.SportRecordService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import com.example.backend.pojo.Vo.SportRecordSaveRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amap.api.maps.model.LatLng;

import java.util.Date;
import java.util.List;

@Service
public class SportRecordServiceImpl implements SportRecordService {

    @Autowired
    private SportRecordDao sportRecordDao;
    @Override
    public List<SportRecordEntity> getAll(Long userId) {
        return sportRecordDao.findAllByUserId(userId);
    }

    @Override
    public List<SportRecordEntity> getByInfo(Long userId,RecordType recordType, Date startDate, Date endDate) {
        List<SportRecordEntity> result;
        if (recordType == null && startDate == null && endDate == null) {
            result = getAll(userId);
        } else if (recordType == null) {
            System.out.println("here");
            result = sportRecordDao.findAllByUserIdAndStartTimeGreaterThanEqualAndStartTimeLessThanEqual(userId, startDate, endDate);
        } else if (startDate == null && endDate == null) {
            System.out.println("here1");
            result = sportRecordDao.findAllByUserIdAndRecordType(userId, recordType);
            System.out.println(result.size());
        } else {
            result = sportRecordDao.findAllByUserIdAndRecordTypeAndStartTimeGreaterThanEqualAndStartTimeLessThanEqual(userId, recordType, startDate, endDate);
        }
        return result;
    }

    @Override
    public SportRecordEntity getById(Long userId, Long id) {
        SportRecordEntity sportRecordEntity = null;
        if(sportRecordDao.findById(id).isPresent())
            sportRecordEntity = sportRecordDao.findById(id).get();
        return sportRecordEntity;
    }

    @Override
    public void saveRecord(Long userId ,SportRecordSaveRequest sportRecordSaveRequest) {
        SportRecordEntity sportRecordEntity = SportRecordEntity.builder()
                .userId(userId)
                .recordType(sportRecordSaveRequest.getRecordType())
                .startTime(sportRecordSaveRequest.getStartTime())
                .endTime(sportRecordSaveRequest.getEndTime())
                .distance(sportRecordSaveRequest.getDistance())
                .duration(sportRecordSaveRequest.getDuration())
                .latitudeList(sportRecordSaveRequest.getLatitudeList())
                .longitudeList(sportRecordSaveRequest.getLongitudeList()).build();
        sportRecordDao.save(sportRecordEntity);
    }


}
