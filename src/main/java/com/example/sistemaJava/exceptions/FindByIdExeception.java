package com.example.sistemaJava.exceptions;

public class FindByIdExeception extends RuntimeException {
    public FindByIdExeception(){
        super("Usuário não encontrado!");
    }
}