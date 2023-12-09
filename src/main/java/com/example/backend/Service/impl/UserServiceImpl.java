package com.example.backend.Service.impl;

import com.example.backend.Dao.UserDao;
import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void login(String username, String password) {
        UserEntity userEntity = userDao.findAllByUsername(username);
        if(userEntity == null)
            throw new RuntimeException();
        else {

        }
    }

    @Override
    public void register(String username, String password) {

    }

    @Override
    public void logOut(String username) {

    }

    @Override
    public double getAllRecordDistance(Long id) {
        return 1;
    }

    @Override
    public double getRecordDistanceByMonth(Long id, int month) {
        return 1;
    }
}
