package com.spring_security._example.repository;

import com.spring_security._example.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
        UserModel findByUsername(String username);
}
