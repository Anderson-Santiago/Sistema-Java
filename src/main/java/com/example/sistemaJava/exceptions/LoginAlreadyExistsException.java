package com.example.sistemaJava.exceptions;

public class LoginAlreadyExistsException extends RuntimeException {
    public LoginAlreadyExistsException() {
        super("Login já utilizado, tente outro!");
    }
}