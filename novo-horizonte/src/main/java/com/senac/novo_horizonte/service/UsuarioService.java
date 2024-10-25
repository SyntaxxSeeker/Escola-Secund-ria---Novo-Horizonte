package com.senac.novo_horizonte.service;

import com.senac.novo_horizonte.data.UsuarioRepository;
import com.senac.novo_horizonte.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> getTodosUsuarios(){
       return usuarioRepository.findAll();
    }


}
