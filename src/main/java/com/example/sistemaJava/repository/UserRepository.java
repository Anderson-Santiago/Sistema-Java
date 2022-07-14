package com.example.sistemaJava.repository;

import com.example.sistemaJava.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByDcrLogin(String dcrLogin);
}
