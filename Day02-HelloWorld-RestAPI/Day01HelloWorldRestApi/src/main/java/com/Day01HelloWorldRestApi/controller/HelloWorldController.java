// This is the package where your controller file is stored.
// It helps Java organize classes into folders.
package com.Day01HelloWorldRestApi.controller;

// Import the necessary Spring annotations
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This annotation tells Spring that this class is a REST API controller
@RestController

// Base URL path for this controller: http://localhost:8080/api
@RequestMapping("/api")
public class HelloWorldController {

    // This annotation maps HTTP GET requests to this method
    // URL: http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String sayHello() {
        // This is the message that will be returned as a plain response
        return "🌍 Hello World! Welcome to Spring Boot!";
    }
}
