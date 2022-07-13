package com.example.sistemaJava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cadusuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long idcadusuario;
    private  String dcr_usuario;
    private  String dcr_login;
    private  String dcr_senha;
}


