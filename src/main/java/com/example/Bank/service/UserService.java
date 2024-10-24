package com.example.Bank.service;

import com.example.Bank.dto.PasswordDTO;
import com.example.Bank.entity.User;
import com.example.Bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User create(User user){
        return repository.save(user);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByEmail(String email){
        return repository.findByEmailContaining(email);
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }

    public User updatePassword(Long id, PasswordDTO pass){
        User user1 = findById(id);
        if (!user1.getPassword().equals(pass.getPassword())){
            throw new RuntimeException("Senha errada!");
        }
        if (!pass.getNewPassword().equals(pass.getConfirmNewPassword())){
            throw new RuntimeException("Senhas diferentes!");
        }
        user1.setPassword(pass.getNewPassword());
        return repository.save(user1);
    }


}
