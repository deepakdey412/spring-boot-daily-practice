package com.deepak.UserManagementService.controller;

import com.deepak.UserManagementService.dto.UserDTO;
import com.deepak.UserManagementService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<UserDTO>> getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Optional<UserDTO>> update(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(Optional.ofNullable(userService.update(id, userDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletebyId(@PathVariable int id) {
        return ResponseEntity.ok("Deleted id " + id);
    }
}
