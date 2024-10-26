package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.entity.TurmaEntity;
import com.senac.novo_horizonte.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @PostMapping("/turma-save")
    public String saveTurma(@ModelAttribute("turma") TurmaEntity turma) {
        turmaService.adicionarTurma(turma);
        return "redirect:/turmas";
    }
}
