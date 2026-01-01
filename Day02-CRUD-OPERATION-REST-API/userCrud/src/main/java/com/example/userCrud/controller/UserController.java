package com.example.userCrud.controller;

import com.example.userCrud.dto.RequestDto;
import com.example.userCrud.dto.ResponseDto;
import com.example.userCrud.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestBody RequestDto requestDto) {
        ResponseDto  responseDto = userService.createUsers(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ResponseDto>> getAllUsers() {
        List<ResponseDto> responseDto = userService.getAllUsers();
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody RequestDto requestDto) {
        ResponseDto  responseDto = userService.updateUsers(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return new ResponseEntity<>("User deleted", HttpStatus.NO_CONTENT);
    }
}
