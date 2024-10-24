package com.senac.novo_horizonte.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "funcionarios")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo 'Nome' não pode ser nulo")
    private String nome;
    @CPF(message = "Insira um CPF válido")
    private String cpf;
    @NotNull(message = "Campo 'Cargo' não pode ser nulo")
    private String cargo;
    @Email(message = "Insira um E-Mail válido")
    private String email;
    @NotNull(message = "Telefone não pode ser nulo")
    private String telefone;
    @NotNull(message = "Campo 'Nome' não pode ser nulo")
    @Column(name = "data_contratacao")
    private String dataContratacao;
}
