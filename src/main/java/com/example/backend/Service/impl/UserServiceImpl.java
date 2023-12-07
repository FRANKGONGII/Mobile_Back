package com.example.backend.Service.impl;

import com.example.backend.Dao.UserDao;
import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<UserEntity> getAll() {

        return userDao.findAll();
    }

    @Override
    public List<UserEntity> getByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public List<UserEntity> getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public UserEntity getById(Long id) {
        Optional<UserEntity> optional = userDao.findById(id);
        return optional.orElse(null);
    }

    @Override
    public double getAllRecordDistance(Long id) {
        UserEntity user = getById(id);
        if(user == null){
            return -1;
        }

        double sum = 0;
        for(SportRecordEntity sportRecord : user.getRecords()){
            sum += sportRecord.getDistance();
        }

        return sum;
    }

    @Override
    public double getRecordDistanceByMonth(Long id, int month) {
        UserEntity user = getById(id);
        if(user == null){
            return -1;
        }

        double sum = 0;
        for(SportRecordEntity sportRecord : user.getRecords()){
            //noinspection deprecation
            if(sportRecord.getStartTime().getMonth() + 1 == month){
                sum += sportRecord.getDistance();
            }
        }

        return sum;
    }

    @Override
    public void login(String userName, String password) {

    }
}
