package com.example.backend.Dao;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SportRecordDao extends CrudRepository<SportRecordEntity, Long> {
    public List<SportRecordEntity> findAllByUserId(Long userId);
    public List<SportRecordEntity> findAllByUserIdAndRecordType(Long userId, RecordType recordType);
    public List<SportRecordEntity> findAllByUserIdAndStartTimeGreaterThanEqualAndStartTimeLessThanEqual(Long userId, Date startTime, Date endTime);
    public List<SportRecordEntity> findAllByUserIdAndRecordTypeAndStartTimeGreaterThanEqualAndStartTimeLessThanEqual(Long userId, RecordType recordType, Date startTime, Date endTime);
}
