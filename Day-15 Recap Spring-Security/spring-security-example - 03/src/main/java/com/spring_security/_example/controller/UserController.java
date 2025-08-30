package com.spring_security._example.controller;

import com.spring_security._example.model.UserModel;
import com.spring_security._example.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel){
        return userService.save(userModel);
    }

    @GetMapping("/get/{id}")
    public Optional<UserModel> getUser(@PathVariable int id){
        return userService.findUser(id);
    }

    @GetMapping("/message")
    public String message() {
        return "welcome to spring security....";
    }

    @GetMapping("/getId")//Session id + CSRF is for MVC design only
    public String getSessionID(HttpServletRequest request) {
        return "Session id is : "+ request.getSession().getId();
    }
}
