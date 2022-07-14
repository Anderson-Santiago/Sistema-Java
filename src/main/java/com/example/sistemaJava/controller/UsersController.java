package com.example.sistemaJava.controller;

import com.example.sistemaJava.mock.User;
import com.example.sistemaJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UsersController {
    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id) {
        User teste = service.findUser(id);
        if (teste != null) {
            return ResponseEntity.ok(teste);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> sendCreateUser(@RequestBody User user) {
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> sendUpdateUser(@RequestBody User user) {
        return ResponseEntity.ok(service.updateUser(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> sendUpdateUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }

}
