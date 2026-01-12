package com.deepak.Demo_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/service1")
    public String service1(){
        return "service 1";
    }

}
