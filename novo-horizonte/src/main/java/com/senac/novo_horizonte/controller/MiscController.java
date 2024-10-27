/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.*;
import com.senac.novo_horizonte.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 *
 * @author josue
 */
@Controller
public class MiscController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TurmaService turmaService;
    @Autowired
    AlunoService alunoService;
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/logar")
    public String logar(@ModelAttribute("usuario") UsuarioDTO usuario, Model model) {
        System.out.println("Logando...");
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
    public String getAlunos(Model model) {
        if (UserLog.getAcesso()){
            model.addAttribute("alunos", alunoService.getTodosAlunos());
            return "alunos";
        }
        return "redirect:/login";
    }

    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        if(UserLog.getAcesso()){
            model.addAttribute("funcionarios", funcionarioService.getTodosFuncionarios());
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
    public String addAlunos(Model model) {
        if (UserLog.getAcesso()){
            model.addAttribute("aluno", new AlunoEntity());
            return "adicionar-aluno";
        }
        return "redirect:/login";
    }

    @GetMapping("/adicionar-funcionarios")
    public String addFuncionarios(Model model) {
        if(UserLog.getAcesso()){
            model.addAttribute("funcionario", new FuncionarioEntity());
            return "adicionar-funcionario";
        }
        return "redirect:/login";
    }

    @GetMapping("/adicionar-turmas")
    public String addTurmas(Model model) {
        if (UserLog.getAcesso()){
            model.addAttribute("turma", new TurmaEntity());
            return "adicionar-turma";
        }
        return "redirect:/login";
    }
}
