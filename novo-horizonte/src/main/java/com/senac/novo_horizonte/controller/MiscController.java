/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.UsuarioDTO;
import com.senac.novo_horizonte.entity.UsuarioEntity;
import com.senac.novo_horizonte.service.Criptografia;
import com.senac.novo_horizonte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author josue
 */
@Controller
public class MiscController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/logar")
    public String logar(@ModelAttribute("usuario") UsuarioDTO usuario, Model model) {

        if (usuarioService.autenticar(usuario.getUsuario(), usuario.getSenha())){
            return "redirect:/principal";
        }

        model.addAttribute("error", "Usuário ou Senha inválidos");
        return "login";
    }

    @GetMapping("/principal")
    public String getPrincipal() {
        return "principal";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "login";
    }

    @GetMapping("/alunos")
    public String getAlunos() {
        return "alunos";
    }

    @GetMapping("/funcionarios")
    public String getFuncionarios() {
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
