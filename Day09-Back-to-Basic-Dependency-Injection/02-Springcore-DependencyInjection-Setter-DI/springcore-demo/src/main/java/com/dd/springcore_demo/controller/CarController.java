package com.dd.springcore_demo.controller;

import com.dd.springcore_demo.component.EngineComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    private EngineComponent myengineComponent;

    //Setter Dependency injection
    @Autowired
    public void setEngineType(EngineComponent engineComponent) {
        this.myengineComponent = engineComponent;
    }

    @GetMapping("/start")
    public String drive() {
        System.out.println("Car is running...");
        return myengineComponent.engineType();
    }
}
