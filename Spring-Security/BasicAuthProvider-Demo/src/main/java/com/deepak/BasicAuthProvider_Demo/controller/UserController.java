package com.deepak.BasicAuthProvider_Demo.controller;

import com.deepak.BasicAuthProvider_Demo.entity.User;
import com.deepak.BasicAuthProvider_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user){   // 👈 @RequestBody lagao
        return userService.saveUser(user);      // 👈 directly save and return
    }
}
