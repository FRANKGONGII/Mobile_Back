package com.example.backend.Service;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    public void login(String username, String password);

    public void register(String username, String password);

    public void logOut(String username);

    public double getAllRecordDistance(Long id);

    public double getRecordDistanceByMonth(Long id, int month);

}
