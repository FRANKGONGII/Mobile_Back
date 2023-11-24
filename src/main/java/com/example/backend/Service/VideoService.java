package com.example.backend.Service;

import com.example.backend.pojo.Entity.VideoEntity;

import java.util.List;

public interface VideoService {
    public List<VideoEntity> getVideos();

    public VideoEntity getVideoById(Long id);
}
