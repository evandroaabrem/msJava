package br.com.otima.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.otima.entity.PerfilEntity;
import br.com.otima.enumeration.PerfilEnum;

@Repository
public interface RoleRepository extends JpaRepository<PerfilEntity, Long> {
  Optional<PerfilEntity> findByName(PerfilEnum name);
}
