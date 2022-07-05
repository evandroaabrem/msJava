package br.com.otima.amqp.impl;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.otima.amqp.AmqpReq;
import br.com.otima.dto.RequestDto;
import br.com.otima.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AmqpReqImpl implements AmqpReq<RequestDto> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${request.routing-key.producerReq}")
	private String queueReq;

	@Value("${request.exchange.producerEx}")
	private String exchange;

	@Override
	@RabbitListener(queues = "${request.routing-key.producerReq}")
	public void consumer(RequestDto t) {
		try {
				
			log.warn(t.getCpf());
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}

	@Override
	public ResponseDto producer(RequestDto request) {

		rabbitTemplate.convertAndSend(queueReq, request);
		return ResponseDto.builder().build();

	}

}
