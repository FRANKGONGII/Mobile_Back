package com.example.backend.Controller;

import com.example.backend.Service.VideoService;
import com.example.backend.pojo.Entity.VideoEntity;
import com.example.backend.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public CommonResponse<?> getVideos(){
        return CommonResponse.success(videoService.getVideos());
    }

    @GetMapping("/video/{id}")
    public CommonResponse<?> getVideos(@PathVariable Long id){
        return CommonResponse.success(videoService.getVideoById(id));
    }
}
