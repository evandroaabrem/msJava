package br.com.otima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otima.entity.UsuarioEntity;
import br.com.otima.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioEntity> getAll() {
		
		return usuarioRepository.findAll();
	}
	
	
	

}
