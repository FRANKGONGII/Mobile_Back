package com.example.backend.Controller;

import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.UserEntity;
import com.example.backend.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public CommonResponse<List<UserEntity>> getUser(){
        return CommonResponse.success(userService.getUsers());
    }

    @PostMapping("/login")
    public CommonResponse<?> login(String username, String password){
        userService.login(username, password);
        return CommonResponse.success();
    }

    @PostMapping("/register")
    public CommonResponse<?> register(String username, String password){
        userService.register(username, password);
        return CommonResponse.success();
    }

    @PostMapping("/logOut")
    public CommonResponse<?> logOut(String username){
        userService.logOut(username);
        return CommonResponse.success();
    }

    @PostMapping("/session")
    public CommonResponse<UserEntity> session(Long id){
        return CommonResponse.success(userService.session(id));
    }
}
