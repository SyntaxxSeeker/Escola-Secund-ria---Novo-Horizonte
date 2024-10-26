package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.FuncionarioEntity;
import com.senac.novo_horizonte.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/save-funcionario")
    public String adicionarFuncionario(@ModelAttribute("funcionario") FuncionarioEntity funcionario){
        funcionarioService.adicionarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }
}
