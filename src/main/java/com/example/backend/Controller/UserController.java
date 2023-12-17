package com.example.backend.Controller;

import com.example.backend.Service.UserService;
import com.example.backend.pojo.Entity.UserEntity;
import com.example.backend.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResponse<Long> login(@RequestParam String username, @RequestParam String password){
        return CommonResponse.success(userService.login(username, password));
    }

    @PostMapping("/register")
    public CommonResponse<?> register(@RequestParam String username, @RequestParam String password){
        userService.register(username, password);
        return CommonResponse.success();
    }

    @PostMapping("/logOut")
    public CommonResponse<?> logOut(@RequestParam String username){
        userService.logOut(username);
        return CommonResponse.success();
    }

    @PostMapping("/session")
    public CommonResponse<UserEntity> session(@RequestParam Long id){
        return CommonResponse.success(userService.session(id));
    }
}
