package com.deepak.redis_demo.controller;

import com.deepak.redis_demo.model.User;
import com.deepak.redis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return  userService.addUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user;
    }



    @GetMapping("/getUsers")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }
}
