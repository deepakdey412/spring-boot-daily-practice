package com.deepak.demo.controlller;


import com.deepak.demo.entity.Users;
import com.deepak.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    //Save
    @PostMapping("/save")
    public ResponseEntity<Users> saveMyUser(@RequestBody Users users){
        Users savedUser = userService.saveUser(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Users> getMyUserById(@PathVariable Long id){
        Users foundUser = userService.getById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.FOUND);
    }
}
