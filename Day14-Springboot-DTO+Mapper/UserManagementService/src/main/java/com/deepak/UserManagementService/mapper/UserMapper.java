package com.deepak.UserManagementService.mapper;

import com.deepak.UserManagementService.dto.UserDTO;
import com.deepak.UserManagementService.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        // ⚠ Password ko DTO me intentionally skip kar rahe hai (security reason)
        return userDTO;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword()); // ✅ Add this
        return userEntity;
    }
}
