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

    public List<User> findUsers(){
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user){
        User handlerUser = repository.findById(user.getIdcadusuario()).orElse(null);
        assert handlerUser != null;
        handlerUser.setDcr_login(user.getDcr_login());
        handlerUser.setDcr_senha(user.getDcr_senha());
        handlerUser.setDcr_usuario(user.getDcr_usuario());
        return repository.save(handlerUser);
    }
    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User removed: " + id;
    }
}
