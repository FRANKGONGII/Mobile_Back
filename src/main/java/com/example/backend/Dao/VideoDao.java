package com.example.backend.Dao;

import com.example.backend.pojo.Entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoDao extends CrudRepository<VideoEntity, Long> {

    public List<VideoEntity> findAll();
}
