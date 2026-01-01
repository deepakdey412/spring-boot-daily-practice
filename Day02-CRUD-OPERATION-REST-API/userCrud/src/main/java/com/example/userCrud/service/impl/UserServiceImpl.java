package com.example.userCrud.service.impl;

import com.example.userCrud.dto.RequestDto;
import com.example.userCrud.dto.ResponseDto;
import com.example.userCrud.entity.Users;
import com.example.userCrud.mapper.DtoMapper;
import com.example.userCrud.repository.UserRepository;
import com.example.userCrud.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final DtoMapper dtoMapper;

    public UserServiceImpl(UserRepository userRepository, DtoMapper dtoMapper) {
        this.userRepository = userRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ResponseDto createUsers(RequestDto requestDto) {

        Optional<Users> foundUser = userRepository.findByEmail(requestDto.getEmail());

        if (foundUser.isPresent()) {
            throw new RuntimeException("User with email " + requestDto.getEmail() + " already exists");
        }

        Users savedUser = userRepository.save(dtoMapper.toEntity(requestDto));

        return dtoMapper.toResponse(savedUser);
    }

    @Override
    public ResponseDto updateUsers(RequestDto requestDto) {
        Users foundUser = userRepository.findByEmail(requestDto.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));

        Users updatedUser = dtoMapper.toEntity(requestDto);

        foundUser.setFirstName(requestDto.getFirstName());
        foundUser.setLastName(requestDto.getLastName());
        foundUser.setEmail(updatedUser.getEmail());

        Users savedUser = userRepository.save(foundUser);

        return dtoMapper.toResponse(savedUser);
    }


    @Override
    public List<ResponseDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new ResponseDto(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteUsers(Integer id) {
        Users foundUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        userRepository.delete(foundUser);
    }
}
