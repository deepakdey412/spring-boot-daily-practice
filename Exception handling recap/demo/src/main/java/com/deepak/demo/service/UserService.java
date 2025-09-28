package com.deepak.demo.service;

import com.deepak.demo.entity.Users;
import com.deepak.demo.exception.UserNotFoundException;
import com.deepak.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
    //Save user
    public Users saveUser(Users users){
        return userRepository.save(users);
    }
    //Get by id
    public Users getById(Long id){
        Users foundUser = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User not find bro..")
        );
        return foundUser;
    }
}
