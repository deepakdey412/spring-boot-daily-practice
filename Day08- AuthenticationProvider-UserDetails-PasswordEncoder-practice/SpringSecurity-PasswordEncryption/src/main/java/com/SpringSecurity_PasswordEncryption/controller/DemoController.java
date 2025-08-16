package com.SpringSecurity_PasswordEncryption.controller;

import com.SpringSecurity_PasswordEncryption.entity.User;
import com.SpringSecurity_PasswordEncryption.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return "User already exists!";
        }
        // Step 1: Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Step 2: Save new user in DB
        userRepo.save(user);
        return "Registration successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Step 1: Fetch user by username
        User existingUser = userRepo.findByUsername(user.getUsername());
        // Step 2: Check user exists and password matches
        if (existingUser != null &&
                passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return "Login successful!";
        }
        return "Invalid username or password!";
    }
}
