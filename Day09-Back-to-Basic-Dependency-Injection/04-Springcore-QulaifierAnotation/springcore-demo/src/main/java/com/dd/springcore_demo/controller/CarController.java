package com.dd.springcore_demo.controller;

import com.dd.springcore_demo.component.Engine;
import com.dd.springcore_demo.component.EngineComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    private final Engine myEngine;

    @Autowired
    CarController(@Qualifier("engineDesign") Engine theEngine){
        this.myEngine = theEngine;
    }

    @GetMapping("/start")
    public  String drive() {
        System.out.println("Car is running...");
        return myEngine.engineType();
    }

}
