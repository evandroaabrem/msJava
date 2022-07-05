package br.com.otima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otima.dto.RequestDto;
import br.com.otima.dto.ResponseDto;
import br.com.otima.service.MensageriaService;

@RestController
@RequestMapping("/api-mensageria")
public class MensageriaController {

	@Autowired
	private MensageriaService mensageriaService;


	  @PostMapping("")
	    public ResponseEntity<ResponseDto> sendToProducer(@RequestBody RequestDto requestDto) {    	
	    	
	        return ResponseEntity.ok(mensageriaService.sendProducer(requestDto));
	    }  
}
