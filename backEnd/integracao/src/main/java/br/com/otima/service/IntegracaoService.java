package br.com.otima.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.otima.dto.EnderecoDto;

@Service
public class IntegracaoService {
	
	public EnderecoDto getCepFromApi(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForObject("https://api.postmon.com.br/v1/cep/" + cep, EnderecoDto.class);
	}
	



}
