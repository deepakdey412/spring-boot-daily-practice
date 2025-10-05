package com.deepak.Chache_Demo.service;

import com.deepak.Chache_Demo.entity.User;
import com.deepak.Chache_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // DB fetch with caching
    @Cacheable("users")
    public Optional<User> findByIdWithCache(Integer id) {
        long start = System.currentTimeMillis();
        Optional<User> user = userRepository.findById(id);
        long end = System.currentTimeMillis();
        System.out.println("Time taken WITH cache: " + (end - start) + " ms");
        return user;
    }

    // DB fetch without caching
    public Optional<User> findByIdWithoutCache(Integer id) {
        long start = System.currentTimeMillis();
        Optional<User> user = userRepository.findById(id);
        long end = System.currentTimeMillis();
        System.out.println("Time taken WITHOUT cache: " + (end - start) + " ms");
        return user;
    }

}
