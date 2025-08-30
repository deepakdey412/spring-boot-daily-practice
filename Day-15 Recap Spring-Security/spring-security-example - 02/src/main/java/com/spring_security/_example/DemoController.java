package com.spring_security._example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/message")
    public String message() {
        return "welcome to spring security....";
    }

    @GetMapping("/getId")//Session id + CSRF is for MVC design only
    public String getSessionID(HttpServletRequest request) {
        return "Session id is : "+ request.getSession().getId();
    }
}
