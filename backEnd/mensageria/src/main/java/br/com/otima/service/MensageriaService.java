package br.com.otima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.otima.amqp.AmqpReq;
import br.com.otima.dto.RequestDto;
import br.com.otima.dto.ResponseDto;
import br.com.otima.enumeration.MensagemTransacaoEnum;


@Service
public class MensageriaService {
	
	@Autowired
	private AmqpReq<RequestDto> amqp;

	
	public ResponseDto sendProducer(RequestDto requestDto) {
		
		try {
			amqp.producer(requestDto);            
    		return ResponseDto.builder().build();            
            
         } catch (Exception ex) {
  			return ResponseDto.builder().typeResponse(MensagemTransacaoEnum.ERRO.getValue()).message(MensagemTransacaoEnum.ERRO.getDescription()).build();            
         }
	}

	



}
