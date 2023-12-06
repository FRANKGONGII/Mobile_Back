package com.example.backend.Dao;

import com.example.backend.pojo.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long> {

}
