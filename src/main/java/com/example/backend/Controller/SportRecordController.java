package com.example.backend.Controller;

import com.example.backend.Service.SportRecordService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("v1")
public class SportRecordController {
    @Autowired
    private SportRecordService sportRecordService;
    @GetMapping("/record/{id}")
    public SportRecordEntity getRecord(@Valid @PathVariable Long id){
        return sportRecordService.getById(id);
    }

    @GetMapping("/record")
    public List<SportRecordEntity> getRecords(){
        return sportRecordService.getAll();
    }

    @PostMapping("/record/save")
    public void saveRecord(@Valid @RequestBody SportRecordEntity sportRecordEntity){
        sportRecordService.saveRecord(sportRecordEntity);
    }
}
