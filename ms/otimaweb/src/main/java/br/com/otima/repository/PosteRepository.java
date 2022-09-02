package br.com.otima.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.otima.entity.PosteEntity;
	
public interface PosteRepository extends JpaRepository<PosteEntity, Integer>, JpaSpecificationExecutor<PosteEntity> {
    @Query(value = "select p  from PosteEntity p" )
	Page<PosteEntity> findPostePage(Pageable pageable);

}
