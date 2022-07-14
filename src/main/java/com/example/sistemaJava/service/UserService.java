package com.example.sistemaJava.service;

import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.exceptions.LoginAlreadyExistsException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaracterSpecialException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaractersException;
import com.example.sistemaJava.exceptions.PasswordVerifyNumberException;
import com.example.sistemaJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findUsers() {
        return repository.findAll();
    }

    public List<User> findUser(Long id) {
        return repository.findAllById(Collections.singleton(id));
    }

    public void validationLogin(User user) throws Exception {
        Boolean login = repository.existsByDcrLogin(user.getDcrLogin());
        if (login) {
            throw new LoginAlreadyExistsException();
        }
        validationPassword(user);
    }

    public void validationPassword(User user) {
        if (user.getDcrSenha().length() < 8) {
            throw new PasswordVerifyCaractersException();
        } else if (!user.getDcrSenha().matches(".*[^0-9a-zA-Z]+.*")) {
            throw new PasswordVerifyCaracterSpecialException();
        } else if (!user.getDcrSenha().matches(".*\\d+.*")) {
            throw new PasswordVerifyNumberException();
        }
    }

    public User saveUser(User user) throws Exception {
        validationLogin(user);
        return repository.save(user);
    }

    public User updateUser(User user) throws Exception {
        User login = repository.findById(user.getIdcadusuario()).orElse(null);
        assert login != null;
        if (!Objects.equals(login.getDcrLogin(), user.getDcrLogin())) {
            validationLogin(user);
        } else {
            validationPassword(user);
        }
        return repository.save(user);
    }

    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User removed: " + id;
    }
}
