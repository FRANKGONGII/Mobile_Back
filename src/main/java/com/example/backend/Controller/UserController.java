package com.example.backend.Controller;

import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

    @Autowired
    private UserService userService;

    public void login(String username, String password){
        userService.login(username, password);
    }

    public void register(String username, String password){
        userService.register(username, password);
    }

    public void logOut(String username){
        userService.logOut(username);
    }
}
