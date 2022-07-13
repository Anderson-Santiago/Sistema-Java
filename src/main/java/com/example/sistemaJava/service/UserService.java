package com.example.sistemaJava.service;

import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User saveProduct(User user) {
        return repository.save(user);
    }

    public List<User> findUsers(){
        return repository.findAll();
    }
}
