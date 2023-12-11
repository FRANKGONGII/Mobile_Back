package com.example.backend.Service;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import com.example.backend.pojo.Vo.SportRecordSaveRequest;

import java.util.Date;
import java.util.List;

public interface SportRecordService {
    public List<SportRecordEntity> getAll(Long userId);

    public List<SportRecordEntity> getByInfo(Long userId, RecordType recordType, Date startDate, Date endDate);

    public SportRecordEntity getById(Long userId ,Long id);

    public void saveRecord(Long userId, SportRecordSaveRequest sportRecordSaveRequest);

    public double getAllRecordDistance(Long id);

    public double getRecordDistanceByMonth(Long id, int month);

}
