package br.com.otima.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.otima.entity.UsuarioEntity;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	
	Optional<UsuarioEntity> findByUsername(String username);
	
	Optional<UsuarioEntity> findByEmail(String email);
	
    Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);



}
