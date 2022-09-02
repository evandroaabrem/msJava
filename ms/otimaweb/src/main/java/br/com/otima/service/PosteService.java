package br.com.otima.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.otima.dto.PosteDto;
import br.com.otima.entity.PosteEntity;
import br.com.otima.enumeration.MensagemGeralEnum;
import br.com.otima.exception.PosteException;
import br.com.otima.repository.PosteRepository;

@Service
public class PosteService {

	@Autowired
	private PosteRepository posteRepository;

	private PosteEntity getPosteById(Integer id) {
		Optional<PosteEntity> obj = posteRepository.findById(id);

		if (!obj.isPresent()) {
			throw new PosteException(MensagemGeralEnum.OBJNAOENCONTRADO.getValueStatus());

		} else {
			return obj.get();

		}

	}

	public PosteDto getById(Integer id) {
		return buildPosteDTO(getPosteById(id));
	}
	
	public PosteDto deleteById(Integer id) {
		PosteEntity poste = getPosteById(id);
		posteRepository.delete(poste);
		
		
		return buildPosteDTO(poste);
	}
	
	public PosteEntity savePoste(PosteDto posteDto) {
		posteDto.setId(null);
		return posteRepository.save(buildPosteEntity(posteDto));
		
	}

	public Page<PosteDto> getAll(Pageable pageable) {

		Page<PosteEntity> postePage = posteRepository.findPostePage(pageable);

		Stream<PosteDto> stream = postePage.stream().map(this::buildPosteDTO);

		long total = postePage.getSize();

		List<PosteDto> content = stream.collect(Collectors.toList());

		return new PageImpl<>(content, pageable, total);

	}

	private PosteDto buildPosteDTO(PosteEntity posteEntity) {
		return PosteDto.builder().id(posteEntity.getId()).bairro(posteEntity.getBairro())
				.identificacao(posteEntity.getIdentificacao())
				.status(HttpStatus.OK.value())
				.build();
	}
	
	
	private PosteEntity buildPosteEntity(PosteDto posteDto) {
		return PosteEntity.builder().id(posteDto.getId() == null ? null : posteDto.getId()).bairro(posteDto.getBairro())
				.identificacao(posteDto.getIdentificacao())
				.build();
	}

	public PosteEntity updatePoste(Integer id, PosteDto posteDto) {
		getPosteById(id);
		posteDto.setId(id);
		return posteRepository.save(buildPosteEntity(posteDto));
	}

}
