package com.demoApp.repository;

import com.demoApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<UserModel , Integer> {
}
