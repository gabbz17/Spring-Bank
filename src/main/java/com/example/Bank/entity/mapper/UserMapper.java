package com.example.Bank.entity.mapper;

import com.example.Bank.dto.UserDTO;
import com.example.Bank.entity.User;

import java.util.List;

public class UserMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getAmount());
    }

    public static List<UserDTO> toAllDto(List<User> usuario) {
        return usuario.stream().map(UserMapper::toDTO).toList();
    }
}
