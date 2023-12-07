package com.example.backend.Service;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAll();

    public List<UserEntity> getByUserName(String userName);

    public List<UserEntity> getByName(String name);

    public UserEntity getById(Long id);

    public double getAllRecordDistance(Long id);

    public double getRecordDistanceByMonth(Long id, int month);

    public void login(String userName, String password);

}
