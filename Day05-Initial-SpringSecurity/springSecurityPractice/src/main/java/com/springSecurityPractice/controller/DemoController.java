package com.springSecurityPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/message")
    public String sendMessage(){
        return "Hii .. i have started spring security from today!!";
    }
}

// this end-point will only work if you give the default log in form user and password genrated in the terminal
// we can customize password in the applicaiton.propertise file