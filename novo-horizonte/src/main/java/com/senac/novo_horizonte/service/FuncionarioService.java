package com.senac.novo_horizonte.service;

import com.senac.novo_horizonte.data.FuncionarioRepository;
import com.senac.novo_horizonte.entity.FuncionarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity adicionarFuncionario(FuncionarioEntity funcionario){
        funcionario.setId(null);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public List<FuncionarioEntity> getTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioEntity getFuncionarioId(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível encontrar funcionário de id: '"+id+"'"));
    }

    public FuncionarioEntity atualizarFuncionario(Long id, FuncionarioEntity funcionarioAtt){
        FuncionarioEntity funcionario = getFuncionarioId(id);
        funcionario.setNome(funcionarioAtt.getNome());
        funcionario.setCpf(funcionarioAtt.getCpf());
        funcionario.setEmail(funcionarioAtt.getEmail());
        funcionario.setCargo(funcionarioAtt.getCargo());
        funcionario.setDataContratacao(funcionarioAtt.getDataContratacao());
        funcionario.setTelefone(funcionarioAtt.getTelefone());
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public void deletarFuncionario(Long id){
        FuncionarioEntity funcionario = getFuncionarioId(id);
        funcionarioRepository.deleteById(funcionario.getId());
    }
}
