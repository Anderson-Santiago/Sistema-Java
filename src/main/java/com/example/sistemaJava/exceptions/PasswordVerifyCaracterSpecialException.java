package com.example.sistemaJava.exceptions;

public class PasswordVerifyCaracterSpecialException extends RuntimeException {
    public PasswordVerifyCaracterSpecialException() {
        super("A senha deve conter pelo menos um caracter especial");
    }
}
