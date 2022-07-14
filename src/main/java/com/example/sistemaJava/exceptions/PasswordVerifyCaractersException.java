package com.example.sistemaJava.exceptions;

public class PasswordVerifyCaractersException extends RuntimeException {
    public PasswordVerifyCaractersException() {
        super("A senha deve conter no mínimo 8 caracteres");
    }
}
