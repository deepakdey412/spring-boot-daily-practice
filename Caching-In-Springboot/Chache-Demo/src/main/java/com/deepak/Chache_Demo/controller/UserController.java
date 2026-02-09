package com.deepak.Chache_Demo.controller;

import com.deepak.Chache_Demo.entity.User;
import com.deepak.Chache_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody  User user){
        return userService.saveUser(user);
    }

    // Cache enabled
//    @GetMapping("/with-cache/{id}")
//    public Optional<User> getWithCache(@PathVariable Integer id) {
//        return userService.findByIdWithCache(id);
//    }
    @GetMapping("/with-cache/{id}")
    public Map<String, Object> getWithCache(@PathVariable Integer id) {
        long start = System.currentTimeMillis();
        User user = userService.findByIdWithCache(id).orElse(null);
        long end = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("timeTakenMs", end - start);
        
        return response;
    }


    // Cache disabled
//    @GetMapping("/without-cache/{id}")
//    public Optional<User> getWithoutCache(@PathVariable Integer id) {
//        return userService.findByIdWithoutCache(id);
//    }
    
    @GetMapping("/without-cache/{id}")
    public Map<String, Object> getWithoutCache(@PathVariable Integer id) {
        long start = System.currentTimeMillis();
        User user = userService.findByIdWithoutCache(id).orElse(null);
        long end = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("timeTakenMs", end - start); 
        
        return response;
    }


}


