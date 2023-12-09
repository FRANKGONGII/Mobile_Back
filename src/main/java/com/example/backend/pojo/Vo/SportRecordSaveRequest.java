package com.example.backend.pojo.Vo;

import com.example.backend.pojo.Enum.RecordType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class SportRecordSaveRequest {
    @NotNull
    private Long userId;

    @NotNull
    private RecordType recordType;

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private double distance; // 跑步距离

    @NotNull
    private int duration; // 跑步时间，秒计

    @NotNull
    public double[] latitudeList;

    @NotNull
    public double[] longitudeList;
}
