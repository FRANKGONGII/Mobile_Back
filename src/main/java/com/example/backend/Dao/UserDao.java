package com.example.backend.Dao;

import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserEntity, Long> {

    public UserEntity findAllByUsername(String username);

    public List<UserEntity> findAll();
}
