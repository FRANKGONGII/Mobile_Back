package com.example.backend.Dao;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SportRecordDao extends CrudRepository<SportRecordEntity, Long> {
    public List<SportRecordEntity> findAll();
    public List<SportRecordEntity> findByRecordType(RecordType recordType);
    public List<SportRecordEntity> findByStartTimeGreaterThanEqualAndStartTimeLessThanEqual(Date startTime, Date endTime);
    public List<SportRecordEntity> findByRecordTypeAndStartTimeGreaterThanEqualAndStartTimeLessThanEqual(RecordType recordType, Date startTime, Date endTime);
}
