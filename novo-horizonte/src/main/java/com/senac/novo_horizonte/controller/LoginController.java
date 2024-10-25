package com.senac.novo_horizonte.controller;

import com.senac.novo_horizonte.service.UsuarioService;
import com.senac.novo_horizonte.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @PutMapping("/logar")
    public String logar(@ModelAttribute("usuario") UsuarioEntity usuario){
        List<UsuarioEntity> usuarios = usuarioService.getTodosUsuarios();
        usuarios.forEach(u -> {
            if (u.getUsuario() == usuario.getUsuario()){

            }
        });
        return "";
    }
}
