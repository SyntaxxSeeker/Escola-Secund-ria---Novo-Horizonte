package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.AlunoEntity;
import com.senac.novo_horizonte.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/save-aluno")
    public String adicionarAluno(@Valid @ModelAttribute("aluno")AlunoEntity aluno, BindingResult result){

        if (result.hasErrors()){
            return "adicionar-aluno";
        }

        if(aluno.getId() == null){
            alunoService.adicionarAluno(aluno);
        }else{
            alunoService.atualizarAlunos(aluno.getId(), aluno);
        }
        return "redirect:/alunos";
    }

    @GetMapping("/deletar-aluno/{id}")
    public String deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return "redirect:/alunos";
    }

    @GetMapping("/atualizar-aluno/{id}")
    public String atualizarAluno(@PathVariable Long id, Model model){
        AlunoEntity aluno = alunoService.getAlunoId(id);
        model.addAttribute("aluno", aluno);
        return "atualizar-aluno";
    }
}
