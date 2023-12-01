package com.example.backend.pojo.Entity;

import com.amap.api.maps.model.LatLng;

import com.example.backend.pojo.Enum.RecordType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

//    @NotNull
//    private List<LatLng> LatLang;

    @NotNull
    public double[] latitudeList;

    @NotNull
    public double[] longitudeList;
}
