package com.deepak.BasicAuthProvider_Demo.service;

import com.deepak.BasicAuthProvider_Demo.entity.User;
import com.deepak.BasicAuthProvider_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User inputUser) {
        // Encode password
        inputUser.setPassword(passwordEncoder.encode(inputUser.getPassword()));
        // Save directly
        return userRepository.save(inputUser);
    }

    public Optional<User> getUserById(Long inputId) {
        return userRepository.findById(inputId);
    }
}
