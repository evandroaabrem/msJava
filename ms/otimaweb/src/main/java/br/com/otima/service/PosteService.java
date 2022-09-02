package br.com.otima.service;

import br.com.otima.dto.PosteDto;
import br.com.otima.entity.PosteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface PosteService {

    public PosteEntity getPosteById(Integer id);

    public PosteDto getById(Integer id);

    public PosteDto deleteById(Integer id);

    public PosteEntity savePoste(PosteDto posteDto);

    public Page<PosteDto> getAll(Specification<PosteEntity> spec, Pageable pageable);

    public PosteEntity updatePoste(Integer id, PosteDto posteDto);


    public PosteDto buildPosteDTO(PosteEntity posteEntity);


    public PosteEntity buildPosteEntity(PosteDto posteDto);
}
