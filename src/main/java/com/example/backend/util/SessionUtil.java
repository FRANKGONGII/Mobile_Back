package com.example.backend.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class SessionUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    private Long loginTime = 1800000L; // 3600000L(1h) 86400000(1天)

    public void login(Long id){
        Date date = new Date();
        Long time = date.getTime();
        redisTemplate.opsForValue().set(id, time + loginTime);
    }

    public void logOut(Long id){
        if(Boolean.TRUE.equals(redisTemplate.hasKey(id))){
            redisTemplate.delete(id);
        }
    }

    public void session(Long id){
        if(Boolean.TRUE.equals(redisTemplate.hasKey(id))){
            Date date = new Date();
            if(date.getTime() > (Long) redisTemplate.opsForValue().get(id)) {
                redisTemplate.delete(id);
                throw new BizException("用户登录过期");
            }
        }
    }
}
