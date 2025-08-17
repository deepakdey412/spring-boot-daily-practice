# Project Name: User Service Demo

## Overview
This is a **Spring Boot project** demonstrating the use of **Constructor Dependency Injection**.  
The project showcases how to manage dependencies in a clean, testable way using Spring's DI mechanism.

## Features
- Constructor Dependency Injection
- User management via `UserService` and `UserRepository`
- Clean, maintainable code following SOLID principles
- Easily testable services

## How Constructor Dependency Injection Works
In this project, `UserService` depends on `UserRepository`.  
Instead of creating the repository inside the service, it is injected via the **constructor**, ensuring:
- Mandatory dependencies are provided
- Easier unit testing
- Clean and maintainable code

```java
@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Dependency Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
