package com.dd.Spring_Data_Jpa_Demo.repository;

import com.dd.Spring_Data_Jpa_Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
