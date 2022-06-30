package otimaWeb;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.otima.dto.CidadeInfoDto;
import br.com.otima.dto.EnderecoDto;
import br.com.otima.dto.EstadoInfoDto;
import br.com.otima.service.IntegracaoService;

@RunWith(SpringRunner.class)
public class IntegracaoTest {

	@InjectMocks
	private IntegracaoService integracaoService;

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void cepApiTest() {
		EnderecoDto end = getEnderecoDto();
		String cep = "13050055";
		when(restTemplate.getForEntity("https://api.postmon.com.br/v1/cep/" + cep, EnderecoDto.class))
				.thenReturn(new ResponseEntity<EnderecoDto>(end, HttpStatus.OK));

		EnderecoDto endDto = integracaoService.getCepFromApi(cep);
		Assertions.assertEquals(end, endDto);
	}

	private EnderecoDto getEnderecoDto() {
		return EnderecoDto.builder()
				.bairro("Vila Mimosa")
				.cidade("Campinas")
				.logradouro("Avenida das Amoreiras")
				.estado_info(EstadoInfoDto.builder().codigo_ibge(35).build())
				.cidade_info(CidadeInfoDto.builder().codigo_ibge(3509502).build())
				.estado("SP")
				.build();

	}
}
