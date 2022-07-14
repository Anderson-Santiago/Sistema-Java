package com.example.sistemaJava.exceptions;

public class PasswordVerifyNumberException extends RuntimeException {
    public PasswordVerifyNumberException() {
        super("A senha deve conter pelo menos um número");
    }
}
