package com.example.Bank.controller;

import com.example.Bank.dto.PasswordDTO;
import com.example.Bank.dto.UserDTO;
import com.example.Bank.entity.User;
import com.example.Bank.entity.mapper.UserMapper;
import com.example.Bank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> dto = UserMapper.toAllDto(list);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User save = service.create(user);
        return ResponseEntity.status(201).body(save);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email){
        User user = service.findByEmail(email);
        UserDTO use = UserMapper.toDTO(user);
        return ResponseEntity.ok().body(use);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @Valid @RequestBody PasswordDTO pass){
        User user1 = service.updatePassword(id, pass);
        return ResponseEntity.ok().body(user1);
    }

}
