package com.senac.novo_horizonte.service;

import com.senac.novo_horizonte.data.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/save-funcionario")
    public String adicionarFuncionario(){
        return null;
    }
}
