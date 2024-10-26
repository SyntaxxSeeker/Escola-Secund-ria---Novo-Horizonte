package com.senac.novo_horizonte.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo 'Nome' não pode ser nulo")
    private String nome;
    @CPF(message = "Insira um CPF válido")
    private String cpf;
    @Column(name = "data_nascimento")
    @NotNull(message = "Data de Nascimento não pode ser nulo")
    private String dataNascimento;
    @NotNull(message = "Matricula não pode ser nula")
    private int matricula;
    @NotNull(message = "Telefone não pode ser nulo")
    private String telefone;
}