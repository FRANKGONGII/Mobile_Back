package com.example.backend.pojo.Enum;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public enum RecordType {
    RUNNING,RIDING,WALKING,FITNESS;
    private static final HashMap<RecordType,String> mp = new HashMap<RecordType,String>(){{
        put(RUNNING,"跑步");
        put(RIDING,"骑行");
        put(WALKING,"健走");
        put(FITNESS,"健身");
    }};

    public static RecordType getValue(String type) {
        for(Map.Entry<RecordType,String> entry : mp.entrySet()){
            if(entry.getValue().equals(type)){
                return entry.getKey();
            }
        }
        log.warn("不存在该状态");
        return null;
    }

    public String getStr(){
        return mp.get(this);
    }
}