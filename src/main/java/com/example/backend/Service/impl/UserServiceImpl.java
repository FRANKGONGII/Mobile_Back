package com.example.backend.Service.impl;

import com.example.backend.Dao.UserDao;
import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.SportRecordEntity;
import com.example.backend.pojo.Entity.UserEntity;
import com.example.backend.util.BizException;
import com.example.backend.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public Long login(String username, String password) {
        UserEntity userEntity = userDao.findAllByUsername(username);
        if (userEntity == null)
            throw new BizException("该用户不存在");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, userEntity.getPassword()))
            throw new BizException("用户名或密码错误");
        sessionUtil.login(userEntity.getId());
        return userEntity.getId();
    }

    @Override
    public void register(String username, String password) {
        UserEntity user = userDao.findAllByUsername(username);
        if(user != null)
            throw new BizException("该用户名已经被注册");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = UserEntity.builder()
                .username(username).password(bCryptPasswordEncoder.encode(password))
                .email("").phone("").build();
        userDao.save(userEntity);
        //默认注册之后自动登录
        sessionUtil.login(userEntity.getId());
    }

    @Override
    public void logOut(String username) {
        UserEntity user = userDao.findAllByUsername(username);
        if(user == null)
            throw new BizException("该用户不存在，错误");
        sessionUtil.logOut(user.getId());
    }

    @Override
    public UserEntity session(Long id) {
        sessionUtil.session(id);
        return userDao.findById(id).get();
    }

}
