package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.FuncionarioEntity;
import com.senac.novo_horizonte.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/save-funcionario")
    public String adicionarFuncionario(@ModelAttribute("funcionario") FuncionarioEntity funcionario){
        if(funcionario.getId() == null){
            funcionarioService.adicionarFuncionario(funcionario);
        }else{
            funcionarioService.atualizarFuncionario(funcionario.getId(), funcionario);
        }

        return "redirect:/funcionarios";
    }

    @GetMapping("/atualizar-funcionario/{id}")
    public String atualizarFuncionario(@PathVariable Long id, Model model){
        FuncionarioEntity funcionario = funcionarioService.getFuncionarioId(id);
        model.addAttribute("funcionario", funcionario);
        return "atualizar-funcionario";
    }

    @GetMapping("/deletar-funcionario/{id}")
    public String deletarFuncionario(@PathVariable Long id){
        funcionarioService.deletarFuncionario(id);
        return "redirect:/funcionarios";
    }
}