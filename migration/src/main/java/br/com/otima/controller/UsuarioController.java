package br.com.otima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otima.entity.UsuarioEntity;
import br.com.otima.repository.UsuarioRepository;

@RestController
@RequestMapping("api-usuario")
public class UsuarioController {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public List<UsuarioEntity> listAll(){
        return usuarioRepository.findAll();
    }

}
