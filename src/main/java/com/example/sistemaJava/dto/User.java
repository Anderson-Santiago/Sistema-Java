package com.example.sistemaJava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    private String dcrUsuario;
    @Column(unique = true)
    private String dcrLogin;
    private String dcrSenha;
}


