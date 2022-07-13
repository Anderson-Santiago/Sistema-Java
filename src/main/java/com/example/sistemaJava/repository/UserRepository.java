package com.example.sistemaJava.repository;

import com.example.sistemaJava.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
