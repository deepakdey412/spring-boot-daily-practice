package com.example.thirddemo.services;

import com.example.thirddemo.models.UserData;
import com.example.thirddemo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepo userRepo;

    public UserData save(UserData userData) {
        return userRepo.save(userData);
    }

    public Optional<UserData> findById(int id) {
        return userRepo.findById(id);
    }
}
