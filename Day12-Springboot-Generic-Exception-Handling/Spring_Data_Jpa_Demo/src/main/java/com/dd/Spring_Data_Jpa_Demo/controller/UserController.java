package com.dd.Spring_Data_Jpa_Demo.controller;

import com.dd.Spring_Data_Jpa_Demo.exception.UserErrorResponce;
import com.dd.Spring_Data_Jpa_Demo.exception.UserNotFoundException;
import com.dd.Spring_Data_Jpa_Demo.model.User;
import com.dd.Spring_Data_Jpa_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Injecting UserService (service layer)
    @Autowired
    private UserService userService;

    // Save a new user
    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User saved successfully";
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        if (id < 0) {
            throw new UserNotFoundException("Invalid user id: " + id);
        }

        Optional<User> result = userService.getUserById(id);

        if (result.isPresent()) {
            return result.get();   // user mila to return karo
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }


    // Update user by ID
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return "Deleted user with ID: " + id;
    }

    // Delete all users
    @DeleteMapping("/deleteAll")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "All users deleted";
    }

    //adding a custom handler
    //(SPECIFIC EXCEPTION)
    @ExceptionHandler
    public ResponseEntity<UserErrorResponce> handleException(UserNotFoundException exc){
        UserErrorResponce errorResponce = new UserErrorResponce();

        errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponce.setMessage(exc.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponce,HttpStatus.NOT_FOUND);
    }

    //GENERIC EXCEPTION
    @ExceptionHandler
    public ResponseEntity<UserErrorResponce> genericException(Exception exc){//Catch all exception

        UserErrorResponce errorResponce = new UserErrorResponce();

        errorResponce.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponce.setMessage(exc.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
    }
}
