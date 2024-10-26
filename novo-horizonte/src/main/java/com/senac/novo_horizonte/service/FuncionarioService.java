package com.senac.novo_horizonte.service;

import com.senac.novo_horizonte.data.FuncionarioRepository;
import com.senac.novo_horizonte.entity.FuncionarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity adicionarFuncionario(FuncionarioEntity funcionario){
        funcionario.setId(null);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }
}
