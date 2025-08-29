package com.deepak.UserManagementService.service;

import com.deepak.UserManagementService.dto.UserDTO;
import com.deepak.UserManagementService.entity.UserEntity;
import com.deepak.UserManagementService.mapper.UserMapper;
import com.deepak.UserManagementService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO){
        UserEntity newUser = userMapper.toEntity(userDTO);
        UserEntity savedUser = userRepository.save(newUser);
        return userMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList(); // Java 16+ (use collect(Collectors.toList()) for Java 8-15)
    }

    public Optional<UserDTO> findById(int id){
        Optional<UserEntity> foundUser = userRepository.findById(id);
        return Optional.ofNullable(userMapper.toDTO(foundUser.get()));
    }

    public UserDTO update(int id, UserDTO userDTO) {
        // DB me record check karo
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update fields
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());

        // Save updated entity
        UserEntity updatedUser = userRepository.save(existingUser);

        // DTO me convert karke return karo
        return userMapper.toDTO(updatedUser);
    }

    public void deleteById(int id) {
        // Check if user exists
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Delete user
        userRepository.delete(existingUser);
    }


}
