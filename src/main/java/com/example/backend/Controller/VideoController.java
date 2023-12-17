package com.example.backend.Controller;

import com.example.backend.Service.VideoService;
import com.example.backend.pojo.Entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public List<VideoEntity> getVideos(){
        return videoService.getVideos();
    }

    @GetMapping("/video/{id}")
    public VideoEntity getVideos(@PathVariable Long id){
        return videoService.getVideoById(id);
    }
}
