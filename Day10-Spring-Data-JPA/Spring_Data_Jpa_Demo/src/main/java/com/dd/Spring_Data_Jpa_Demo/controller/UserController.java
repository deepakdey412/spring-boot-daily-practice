package com.dd.Spring_Data_Jpa_Demo.controller;

import com.dd.Spring_Data_Jpa_Demo.model.User;
import com.dd.Spring_Data_Jpa_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")  
public class UserController {

    @Autowired
    private UserService userService;

    // Save a new user
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "User saved successfully";
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    // Update user by ID
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return "Deleted user with ID: " + id;
    }

    // Delete all users
    @DeleteMapping("/deleteAll")
    public String deleteAllUsers(){
        userService.deleteAllUsers();
        return "All users deleted";
    }
}

