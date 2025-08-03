package com.example.thirddemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 4, message = "Enter the name of min 4 characters")
    private String name;

    @Email
    @NotBlank(message = "Enter a valid email...")
    private String email;

    @NotNull
    @Pattern(regexp = "^[1-9][0-9]{2,}$", message = "Roll no should be a number of at least 3 digits")
    private String rollno;

    public UserData() {}

    public UserData(String name, String email, String rollno) {
        this.name = name;
        this.email = email;
        this.rollno = rollno;
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

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
}
