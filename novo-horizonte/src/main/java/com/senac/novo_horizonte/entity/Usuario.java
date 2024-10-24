package com.senac.novo_horizonte.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 4, message = "Informe no minímo 4 caracters para 'User'")
    private String usuario;
    @NotNull
    private String senha;
}