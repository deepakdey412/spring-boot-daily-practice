package com.demoApp.controller;

import com.demoApp.model.UserModel;
import com.demoApp.services.DemoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final  DemoServices demoServices;
    public DemoController (DemoServices demoServices){
        this.demoService = demoservice;
    }

    @PostMapping("/save")
    public String saveUer(@RequestBody UserModel userModel){
        demoServices.saveUser(userModel);
        return "Saved user!!";
    }
    @GetMapping("/printAllUser")
    public List<UserModel> printAllUser(){
        return demoServices.getAllUser();
    }
    @GetMapping("/getbyid/{id}")
    public Optional<UserModel> findbyid(@PathVariable int id){
        return demoServices.getUerByid(id);
    }
    @DeleteMapping("/deleteByid/{id}")
    public String deletebyid(@PathVariable int id){
        return demoServices.deleteByid(id);
    }

    @DeleteMapping("/deleteAll")
    public String deletebyid(){
        return demoServices.deleteAll();
    }


}

