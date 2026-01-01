package com.example.userCrud.service;

import com.example.userCrud.dto.RequestDto;
import com.example.userCrud.dto.ResponseDto;

import java.util.List;

public interface IUserService {
    public ResponseDto createUsers(RequestDto requestDto);
    public ResponseDto updateUsers(RequestDto requestDto);
    public List<ResponseDto> getAllUsers();
    public void deleteUsers(Integer id);
}
