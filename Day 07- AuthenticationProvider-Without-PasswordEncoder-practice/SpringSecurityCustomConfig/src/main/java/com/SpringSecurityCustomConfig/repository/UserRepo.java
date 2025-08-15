package com.SpringSecurityCustomConfig.repository;


import com.SpringSecurityCustomConfig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username); // matches entity field
}


