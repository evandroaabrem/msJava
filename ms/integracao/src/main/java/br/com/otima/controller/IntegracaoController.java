package br.com.otima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otima.dto.EnderecoDto;
import br.com.otima.service.IntegracaoService;

@RestController
@RequestMapping("/api-integracao")
public class IntegracaoController {

	@Autowired
	private IntegracaoService integracaoService;

	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoDto> getCepFromApi(@PathVariable("cep") String cep) {
		return ResponseEntity.ok().body(integracaoService.getCepFromApi(cep));
	}

}
