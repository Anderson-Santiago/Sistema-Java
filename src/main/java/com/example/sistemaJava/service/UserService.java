package com.example.sistemaJava.service;

import com.example.sistemaJava.controller.ValidationController;
import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findUsers(){
        return repository.findAll();
    }
    public ResponseEntity<?> validation(User user) throws Exception {
        if(repository.existsByDcrLogin(user.getDcrLogin())){
            return new ValidationController().exceptionLoginExists();
        }
        if (user.getDcrSenha().length() < 8) {
            return new ValidationController().exceptionPassword8c();
        }
        else if (!user.getDcrSenha().matches(".*\\d+.*")) {
            return new ValidationController().exceptionLPassword1Number();
        }
        else if (!user.getDcrSenha().matches(".*[^0-9a-zA-Z]+.*")) {
            return new ValidationController().exceptionPassword1Symbol();
        }
        return ResponseEntity.ok(repository.save(user));

    }
    public ResponseEntity<?> saveUser(User user) throws Exception {
        return validation(user);
    }

    public ResponseEntity<?> updateUser(User user) throws Exception {
        return validation(user);
    }
    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User removed: " + id;
    }
}
