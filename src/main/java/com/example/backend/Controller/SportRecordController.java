package com.example.backend.Controller;

import com.example.backend.Service.SportRecordService;
import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Enum.RecordType;
import com.example.backend.pojo.Vo.SportRecordSaveRequest;
import com.example.backend.util.CommonResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@Slf4j
@RestController()
@RequestMapping("v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class SportRecordController {

    @Autowired
    private SportRecordService sportRecordService;

    @GetMapping("/record/{id}")
    public CommonResponse<SportRecordEntity> getRecord(@Valid @PathVariable Long id, @RequestParam Long userId){
        return CommonResponse.success(sportRecordService.getById(userId ,id));
    }

    @GetMapping("/record")
    public CommonResponse<List<SportRecordEntity>> getRecords(@RequestParam Long userId){
        return CommonResponse.success(sportRecordService.getAllByUser(userId));
    }

    @GetMapping("/recordByUser/{id}")
    public CommonResponse<?> getRecordByUserId(@Valid @PathVariable Long id){
        return CommonResponse.success(sportRecordService.getAllByUser(id));
    }


    @GetMapping("/allRecords")
    public CommonResponse<List<SportRecordEntity>> getAllRecords(){
        return CommonResponse.success(sportRecordService.findAll());
    }

    @GetMapping("/record/info")
    public CommonResponse<List<SportRecordEntity>> getRecordsByInfo(
            @Valid @RequestParam Long userId,
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



        return CommonResponse.success(sportRecordService.getByInfo(userId, type, st, et));
    }

    @PostMapping("/record/save")
    public CommonResponse<?> saveRecord(@Valid @RequestParam Long userId, @Valid @RequestBody SportRecordSaveRequest sportRecordSaveRequest){
        log.info(String.valueOf(sportRecordSaveRequest.getEndTime()));
        sportRecordService.saveRecord(userId, sportRecordSaveRequest);
        return CommonResponse.success();
    }

    @GetMapping("/distances/{id}")
    public CommonResponse<Double> getDistance(@Valid @PathVariable Long id){
        return CommonResponse.success(sportRecordService.getAllRecordDistance(id));
    }

    @GetMapping("/distance/{id}")
    public CommonResponse<Double> getDistance(@Valid @PathVariable Long id, @RequestParam int month){
        return CommonResponse.success(sportRecordService.getRecordDistanceByMonth(id, month));
    }
}