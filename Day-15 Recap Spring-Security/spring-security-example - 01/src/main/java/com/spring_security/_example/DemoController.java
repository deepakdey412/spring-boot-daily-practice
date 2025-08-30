package com.spring_security._example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/message")
    public String message() {
        return "welcome to spring security....";
    }

    @GetMapping("/getId")
    public String getSessionID(HttpServletRequest request) {// httpServerlet is beccause the whole project is running on that
        return "Session id is : "+ request.getSession().getId();
    }
}
//Session id + CSRF is only for the MVC