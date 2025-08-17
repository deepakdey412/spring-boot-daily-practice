package com.dd.springcore_demo.controller;

import com.dd.component.EngineComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    private final EngineComponent engineComponent;

    @Autowired
    CarController(EngineComponent engineComponent){
        this.engineComponent = engineComponent;
    }

    @GetMapping("/start")
    public  String drive() {
        System.out.println("Car is running...");
        return engineComponent.engineType();
    }

}
