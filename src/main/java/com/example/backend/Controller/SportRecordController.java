package com.example.backend.Controller;

import com.example.backend.Service.SportRecordService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/record/info")
    public List<SportRecordEntity> getRecordsByInfo(
            @Valid @RequestParam RecordType recordType, @Valid @RequestParam Date startDate, @Valid @RequestParam Date endDate){
        return sportRecordService.getByInfo(recordType, startDate, endDate);
    }

    @PostMapping("/recordve")
    public void saveRecord(@Valid @RequestBody SportRecordEntity sportRecordEntity){
        System.out.println(sportRecordEntity.getId());
        System.out.println(sportRecordEntity.getEndTime());
        sportRecordService.saveRecord(sportRecordEntity);
    }

}