// Define the package location (helps organize your files)
package com.Day01HelloWorldRestApi.controller;

// Import required Spring annotations
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Mark this class as a REST Controller
@RestController

// Base URL path for this controller: http://localhost:8080/api/messaage
@RequestMapping("/api")
public class OtherDemoController {

    @GetMapping("/message")
    public String sendMessage() {
        // This message will be returned as plain text in the browser or Postman
        return "👋 Hello! My name is Deepak. I have started a new journey of learning Spring Boot from beginner to advanced.";
    }
}
