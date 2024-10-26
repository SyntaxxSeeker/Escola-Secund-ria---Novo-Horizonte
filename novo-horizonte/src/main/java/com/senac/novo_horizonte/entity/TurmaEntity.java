package com.senac.novo_horizonte.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "turmas")
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Campo 'N° Turma' não pode ser nulo")
    @Column(name = "numero_turma")
    private int numeroTurma;
    @NotNull(message = "Campo 'Professor' não pode ser nulo")
    private String professor;
    @NotNull(message = "Campo 'Turno' não pode ser nulo")
    private String turno;
    @NotNull(message = "Campo 'N° Alunos' não pode ser nulo")
    @Column(name = "numero_alunos")
    private int numeroAlunos;
}