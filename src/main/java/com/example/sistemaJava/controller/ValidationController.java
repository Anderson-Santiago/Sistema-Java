package com.example.sistemaJava.controller;

import com.example.sistemaJava.dto.MessageExceptionHandler;
import com.example.sistemaJava.exceptions.LoginAlreadyExistsException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaracterSpecialException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaractersException;
import com.example.sistemaJava.exceptions.PasswordVerifyNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ValidationController {

    MessageExceptionHandler messageExceptionHandler = new MessageExceptionHandler();

    @ExceptionHandler(LoginAlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionLoginExists() {
        messageExceptionHandler.setMessage("Login já utilizado, tente outro!");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(PasswordVerifyCaractersException.class)
    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionPasswordCaracters() {
        messageExceptionHandler.setMessage("A senha deve conter no mínimo 8 caracteres");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(PasswordVerifyCaracterSpecialException.class)
    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionPasswordCaractersSpecial() {
        messageExceptionHandler.setMessage("A senha deve conter pelo menos 1 Simbolo");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(PasswordVerifyNumberException.class)
    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionPasswordNumber() {
        messageExceptionHandler.setMessage("A senha deve conter pelo menos um número");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }
}
