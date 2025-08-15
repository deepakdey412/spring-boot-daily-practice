package com.SpringSecurityCustomConfig.controller;

import com.SpringSecurityCustomConfig.entity.User;
import com.SpringSecurityCustomConfig.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null) {
            return "User already exists!";
        }
        userRepo.save(user);
        return "Registration successful!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        }
        return "Invalid username or password!";
    }
}

//  WORKING FLOW OF LOG_IN
// Step 1: Client (user) sends a POST request with username and password in JSON format.
//         Example: { "username": "deepak", "password": "1234" }

// Step 2: Spring Boot automatically changes this JSON into a User object.
//         Now, inside the 'user' variable, we have username and password from the request.

// Step 3: We take the username from this 'user' object and search the database for a record
//         where the username is the same.

// Step 4: If the database finds a matching username, it gives us that user's full details
//         as another User object (called 'existingUser').

// Step 5: We now compare the password that came from the request
//         with the password stored in the database for this user.

// Step 6: If both passwords are exactly the same, we say "Login successful!".

// Step 7: If no user is found in the database OR the passwords do not match,
//         we send back "Invalid username or password!".
