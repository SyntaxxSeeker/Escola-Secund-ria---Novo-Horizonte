/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.UsuarioDTO;
import com.senac.novo_horizonte.entity.UsuarioEntity;
import com.senac.novo_horizonte.service.Criptografia;
import com.senac.novo_horizonte.service.UserLog;
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

        if(UserLog.getAcesso()){
            return "principal";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "login";
    }

    @GetMapping("/alunos")
    public String getAlunos() {
        if (UserLog.getAcesso()){
            return "alunos";
        }
        return "redirect:/login";
    }

    @GetMapping("/funcionarios")
    public String getFuncionarios() {
        if(UserLog.getAcesso()){
            return "funcionarios";
        }
        return "redirect:/login";
    }

    @GetMapping("/turmas")
    public String getTurma() {
        if (UserLog.getAcesso()){
            return "turmas";
        }
        return "redirect:/login";
    }

    @GetMapping("/adicionar-alunos")
    public String addAlunos() {
        if (UserLog.getAcesso()){
            return "adicionar-aluno";
        }
        return "redirect:/login";
    }

    @GetMapping("/adicionar-funcionarios")
    public String addFuncionarios() {
        if(UserLog.getAcesso()){
            return "adicionar-funcionario";
        }
        return "redirect:/login";
    }

    @GetMapping("/adicionar-turmas")
    public String addTurmas() {
        if (UserLog.getAcesso()){
            return "adicionar-turma";
        }
        return "redirect:/login";
    }
}
