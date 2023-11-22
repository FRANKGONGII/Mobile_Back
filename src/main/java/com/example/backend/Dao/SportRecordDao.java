package com.example.backend.Dao;

import com.example.backend.pojo.Entity.SportRecordEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportRecordDao extends CrudRepository<SportRecordEntity, Long> {
    public List<SportRecordEntity> findAll();
}
