package com.example.backend.Service.impl;

import com.example.backend.Dao.SportRecordDao;
import com.example.backend.Service.SportRecordService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amap.api.maps.model.LatLng;

import java.util.List;

@Service
public class SportRecordServiceImpl implements SportRecordService {
    @Autowired
    private SportRecordDao sportRecordDao;
    @Override
    public List<SportRecordEntity> getAll() {
        return sportRecordDao.findAll();
    }

    @Override
    public SportRecordEntity getById(Long id) {
        SportRecordEntity sportRecordEntity = null;
        if(sportRecordDao.findById(id).isPresent())
            sportRecordEntity = sportRecordDao.findById(id).get();
        return sportRecordEntity;
    }

    @Override
    public void saveRecord(SportRecordEntity sportRecordEntity) {
        sportRecordDao.save(sportRecordEntity);
    }
}
