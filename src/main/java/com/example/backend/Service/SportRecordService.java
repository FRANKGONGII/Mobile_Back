package com.example.backend.Service;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;

import java.util.Date;
import java.util.List;

public interface SportRecordService {
    public List<SportRecordEntity> getAll();

    public List<SportRecordEntity> getByInfo(RecordType recordType, Date startDate, Date endDate);

    public SportRecordEntity getById(Long id);

    public void saveRecord(SportRecordEntity sportRecordEntity);
}
