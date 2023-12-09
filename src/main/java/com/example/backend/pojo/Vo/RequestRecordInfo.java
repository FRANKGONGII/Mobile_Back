package com.example.backend.pojo.Vo;

import com.example.backend.pojo.Enum.RecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class RequestRecordInfo {
    @Getter
    private Date startTime;
    @Getter
    private Date endTime;
    @Getter
    private String type;
}
