package com.deepak.redis_demo.service;

import com.deepak.redis_demo.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UserService {

    private final HashOperations<String, Integer, User> hashOperations;

    public UserService(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public String addUser(User user) {
        hashOperations.put("USER", user.getId(), user);
        return "User Added Successfully";
    }

    public User getUser(Integer id) {
        return hashOperations.get("USER", id);
    }

    public Collection<User> getUsers() {
        Map<Integer, User> users = hashOperations.entries("USER");
        return users.values();
    }
}
