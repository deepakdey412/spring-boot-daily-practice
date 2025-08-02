package com.demoApp.services;

import com.demoApp.model.UserModel;
import com.demoApp.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoServices {

    @Autowired
    DemoRepository demoRepository;

    public UserModel saveUser(UserModel userModel){
        return demoRepository.save(userModel);
    }

    public List<UserModel> getAllUser(){
        return demoRepository.findAll();
    }

    public Optional<UserModel> getUerByid(int id){
        return demoRepository.findById(id);
    }

    public String deleteByid(int id){
        demoRepository.deleteById(id);
        return "Student deleted!!!";
    }
    public String deleteAll(){
        demoRepository.deleteAll();
        return "All Student deleted!!";
    }

}
