package com.example.Bank.service;

import com.example.Bank.entity.User;
import com.example.Bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User updatePassword(Long id, User user){
        User user1 = findById(id);
        user1.setPassword(user.getPassword());
        return repository.save(user1);
    }


}
