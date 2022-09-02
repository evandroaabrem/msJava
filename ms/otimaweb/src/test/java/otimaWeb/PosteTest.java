package otimaWeb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.otima.dto.PosteDto;
import br.com.otima.entity.PosteEntity;
import br.com.otima.repository.PosteRepository;
import br.com.otima.service.PosteService;



@RunWith(SpringRunner.class)
public class PosteTest {

	@InjectMocks
	private PosteService posteService;

	@Mock
	private PosteRepository posteRepository;

	@Test
	public void getByIdTest() {
		PosteEntity posteEntity = getPosteEntity();
		Optional<PosteEntity> opPoste = Optional.of(posteEntity);
		when(posteRepository.findById(1)).thenReturn(opPoste);
		assertThat(posteService.getById(1)).isNotNull();

	}

	@Test
	public void deleteTest() {
		PosteEntity posteEntity = getPosteEntity();
		Optional<PosteEntity> opPoste = Optional.of(posteEntity);
		when(posteRepository.findById(1)).thenReturn(opPoste);
		assertThat(posteService.deleteById(1)).isNotNull();

	}

	@Test
	public void saveTest() {
		PosteDto posteDto = savePosteDto();
		PosteEntity posteEntity = savePosteEntity();
		when(posteRepository.save(posteEntity)).thenReturn(posteEntity);
		assertThat(posteService.savePoste(posteDto)).isNotNull();

	}

	@Test
	public void updateTest() {
		PosteDto posteDto = updatePosteDto();
		PosteEntity posteEntity = getPosteEntity();
		when(posteRepository.save(posteEntity)).thenReturn(posteEntity);
		Optional<PosteEntity> opPoste = Optional.of(posteEntity);
		when(posteRepository.findById(1)).thenReturn(opPoste);
		assertThat(posteService.updatePoste(posteEntity.getId(), posteDto)).isNotNull();

	}
	
	@Test
    public void getAllPaginatedTest() {
        Pageable pageable = PageRequest.of(0, 5);
        List<PosteEntity> lstPoste = new ArrayList<>();
        lstPoste.add(getPosteEntity());
        Page<PosteEntity> pagedResponse = new PageImpl<PosteEntity>(lstPoste);
		when(posteRepository.findPostePage(pageable)).thenReturn(pagedResponse);
		assertThat(posteService.getAll(pageable)).isNotNull();


    }

	private PosteEntity getPosteEntity() {
		return PosteEntity.builder().id(1).bairro("Vila Mimosa").identificacao("12").build();
	}

	private PosteEntity savePosteEntity() {
		return PosteEntity.builder().id(null).bairro("Vila Mimosa").identificacao("12").build();
	}

	private PosteDto savePosteDto() {
		return PosteDto.builder().id(null).bairro("Vila Mimosa").identificacao("12").build();
	}

	private PosteDto updatePosteDto() {
		return PosteDto.builder().id(1).bairro("Vila Mimosa").identificacao("12").build();
	}

}
