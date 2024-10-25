/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.UsuarioEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author josue
 */
@Controller
public class MiscController {

    @GetMapping("/principal")
    public String getPrincipal() {
        return "principal";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @GetMapping("/alunos")
    public String getAlunos() {
        return "alunos";
    }

    @GetMapping("/funcionarios")
    public String getFunciorios() {
        return "funcionarios";
    }

    @GetMapping("/turmas")
    public String getTurma() {
        return "turmas";
    }

    @GetMapping("/adicionar-alunos")
    public String addAlunos() {
        return "adicionar-aluno";
    }

    @GetMapping("/adicionar-funcionarios")
    public String addFuncionarios() {
        return "adicionar-funcionario";
    }

    @GetMapping("/adicionar-turmas")
    public String addTurmas() {
        return "adicionar-turma";
    }
}
