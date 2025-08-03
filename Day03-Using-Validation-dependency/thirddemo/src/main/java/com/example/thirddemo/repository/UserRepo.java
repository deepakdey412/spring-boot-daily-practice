package com.example.thirddemo.repository;

import com.example.thirddemo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserData , Integer> {
}
