package com.example.userCrud.mapper;

import com.example.userCrud.dto.RequestDto;
import com.example.userCrud.dto.ResponseDto;
import com.example.userCrud.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public Users toEntity(RequestDto requestDto) {
        Users users = new Users();
        users.setFirstName(requestDto.getFirstName());
        users.setLastName(requestDto.getLastName());
        users.setEmail(requestDto.getEmail());
        users.setPassword(requestDto.getPassword());
        return users;
    }

    public ResponseDto toResponse(Users users) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setFirstName(users.getFirstName());
        responseDto.setLastName(users.getLastName());
        responseDto.setEmail(users.getEmail());
        return responseDto;
    }

}
