package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.AlunoEntity;
import com.senac.novo_horizonte.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/save-aluno")
    public String adicionarAluno(@ModelAttribute("aluno")AlunoEntity aluno){
        System.out.println("Entrei kkk");
        if(aluno.getId() == null){
            System.out.println("não Tenho");
            alunoService.adicionarAluno(aluno);
        }else{
            System.out.println("tenho");
            alunoService.atualizarAlunos(aluno.getId(), aluno);
        }
        return "redirect:/alunos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return "redirect:/alunos";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarAluno(@PathVariable Long id, Model model){
        AlunoEntity aluno = alunoService.getAlunoId(id);
        model.addAttribute("aluno", aluno);
        return "atualizar-aluno";
    }
}
