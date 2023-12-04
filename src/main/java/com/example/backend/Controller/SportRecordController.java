package com.example.backend.Controller;

import ch.qos.logback.core.pattern.color.YellowCompositeConverter;
import com.example.backend.Request.RequestRecordInfo;
import com.example.backend.Service.SportRecordService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

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
            @Valid @RequestParam String endDate,
            @Valid @RequestParam String recordType,
            @Valid @RequestParam String startDate)  {
        System.out.println("test:"+recordType+" "+startDate+" "+endDate);

        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Macao"));
        Date st = null;
        Date et = null;
        try{
            st = format.parse(startDate);
            et = format.parse((endDate));
        }catch (ParseException e){
            System.out.println("exception: "+e);
        }




        RecordType type = null;
        if(Objects.equals(recordType, "null")){
            System.out.println("test");

        }
        if(Objects.equals(recordType, "RUNNING")){
            type = RecordType.RUNNING;
        }else if(Objects.equals(recordType, "SWIMMING")){
            type = RecordType.SWIMMING;
        }
        else if(Objects.equals(recordType, "RIDING")){
            type = RecordType.RIDING;
        }
        else if(Objects.equals(recordType, "WALKING")){
            type = RecordType.WALKING;
        }



        return sportRecordService.getByInfo(type, st, et);
    }

    @PostMapping("/record/save")
    public void saveRecord(@Valid @RequestBody SportRecordEntity sportRecordEntity){
        System.out.println(sportRecordEntity.getId());
        System.out.println(sportRecordEntity.getEndTime());
        sportRecordService.saveRecord(sportRecordEntity);
    }

}