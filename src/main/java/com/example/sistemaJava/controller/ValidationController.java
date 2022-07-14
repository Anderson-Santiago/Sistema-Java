package com.example.sistemaJava.controller;

import com.example.sistemaJava.dto.MessageExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice(basePackages = "com.example.sistemaJava.controller")
public class ValidationController {

    MessageExceptionHandler messageExceptionHandler = new MessageExceptionHandler();

    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionLoginExists() {
        messageExceptionHandler.setMessage("Login já utilizado, tente outro!");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionPassword8c() {
        messageExceptionHandler.setMessage("A senha deve conter no mínimo 8 caracteres");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionLPassword1Number() {
        messageExceptionHandler.setMessage("A senha deve conter pelo menos um número");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }

    @ResponseBody
    public ResponseEntity<MessageExceptionHandler> exceptionPassword1Symbol() {
        messageExceptionHandler.setMessage("A senha deve conter pelo menos 1 Simbolo");
        return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST);

    }
}
