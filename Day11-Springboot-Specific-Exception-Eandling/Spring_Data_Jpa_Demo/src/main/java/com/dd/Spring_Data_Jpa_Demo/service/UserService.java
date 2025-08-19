package com.dd.Spring_Data_Jpa_Demo.service;

import com.dd.Spring_Data_Jpa_Demo.model.User;
import com.dd.Spring_Data_Jpa_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Update user details by ID
    public User updateUser(int id, User updatedUser) {
        // Fetch existing user from DB
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Update fields
        existingUser.setName(updatedUser.getName());
        existingUser.setRoll_no(updatedUser.getRoll_no());
        existingUser.setEmail(updatedUser.getEmail());

        // Save updated user
        return userRepository.save(existingUser);
    }

    // Delete user by ID
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    // Delete all users
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
