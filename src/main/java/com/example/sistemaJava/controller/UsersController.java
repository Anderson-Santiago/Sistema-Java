package com.example.sistemaJava.controller;

import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsersController {
    @Autowired
    private UserService service;


    @GetMapping
    public List<User> findAll() {
        return service.findUsers();
    }

    @PostMapping(path = "/create")
    public User sendCreateUser(@RequestBody User user) {
        return service.saveProduct(user);
    }

}
