package com.example.sistemaJava.controller;

import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api")
public class UsersController {
    @Autowired
    private UserService service;


    @GetMapping
    public List<User> findAll() {
        return service.findUsers();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<User>> findByIdUser(@PathVariable Long id){
        return ResponseEntity.ok(service.findUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> sendCreateUser(@RequestBody User user) throws Exception {
        return service.saveUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> sendUpdateUser(@RequestBody User user) throws Exception {
        return service.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String sendUpdateUser(@PathVariable Long id){
        return service.deleteUser(id);
    }

}
