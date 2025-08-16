package com.SpringSecurity_PasswordEncryption.repository;


import com.SpringSecurity_PasswordEncryption.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username); // matches entity field
}


