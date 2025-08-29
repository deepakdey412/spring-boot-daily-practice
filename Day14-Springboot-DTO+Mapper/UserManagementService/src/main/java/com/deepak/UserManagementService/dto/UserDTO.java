package com.deepak.UserManagementService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {

    private int id;

    @NotNull(message = "Enter your name")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 15 characters")
    private String name;

    @Email(message = "Enter a valid email")
    @NotNull(message = "Enter your email")
    private String email;

    @NotNull(message = "Enter your password")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
