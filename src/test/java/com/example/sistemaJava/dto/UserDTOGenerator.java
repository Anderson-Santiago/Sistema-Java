package com.example.sistemaJava.dto;

public class UserDTOGenerator {
    public static User buildFullCreateDTO() {
        return User.builder()
                .dcrUsuario("Anderson749")
                .dcrLogin("AndersonSantiago")
                .dcrSenha("Anderson123#")
                .build();

    }    public static User buildFullUpdateDTO() {
        return User.builder()
                .idcadusuario(1L)
                .dcrUsuario("Anderson749")
                .dcrLogin("Anderson74")
                .dcrSenha("Anderson321#")
                .build();

    }
    public static User buildIncompletePasswordCaracter() {
        return User.builder()
                .dcrUsuario("Anderson749")
                .dcrLogin("AndersonSantiago")
                .dcrSenha("Anders")
                .build();

    }
    public static User buildIncompletePasswordNumber() {
        return User.builder()
                .dcrUsuario("Anderson749")
                .dcrLogin("AndersonSantiago")
                .dcrSenha("Anderson#")
                .build();

    }
    public static User buildIncompletePasswordCaracterSpecial() {
        return User.builder()
                .dcrUsuario("Anderson749")
                .dcrLogin("AndersonSantiago")
                .dcrSenha("Anderson123")
                .build();

    }
    public static User buildExistsLogin() {
        return User.builder()
                .dcrUsuario("Anderson749")
                .dcrLogin("Anderson74")
                .dcrSenha("Anderson123#")
                .build();

    }

}