package com.example.backend.Service.impl;

import com.example.backend.Dao.VideoDao;
import com.example.backend.Service.VideoService;
import com.example.backend.pojo.Entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<VideoEntity> getVideos() {
        return videoDao.findAll();
    }

    @Override
    public VideoEntity getVideoById(Long id) {
        Optional<VideoEntity> videoEntity = videoDao.findById(id);
        return videoEntity.orElse(null);
    }
}
