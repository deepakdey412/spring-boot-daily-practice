package com.example.thirddemo.controller;

import com.example.thirddemo.models.UserData;
import com.example.thirddemo.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/save")
    public UserData saveUser(@Valid @RequestBody UserData userData){
        return userServices.save(userData);
    }
    @GetMapping("/{id}")
    public Optional<UserData> findUser(@PathVariable int id) {
        return userServices.findById(id);
    }



}
