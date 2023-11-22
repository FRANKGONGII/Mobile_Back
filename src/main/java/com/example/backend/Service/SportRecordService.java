package com.example.backend.Service;

import com.example.backend.pojo.Entity.SportRecordEntity;

import java.util.List;

public interface SportRecordService {
    public List<SportRecordEntity> getAll();

    public SportRecordEntity getById(Long id);

    public void saveRecord(SportRecordEntity sportRecordEntity);
}
