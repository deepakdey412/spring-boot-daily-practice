package com.SpringSecurityCustomConfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/message")
    public String sendMessaage(){
        return "Hii.. wil-come to SpringSecurity Custom Configuration ..\n in this project file we have covered the topic Security filter chain and UserDetailsProvider";
    }
}
