package br.com.otima.amqp.impl;

import br.com.otima.amqp.AmqpReq;
import br.com.otima.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AmqpReqImpl implements AmqpReq<RequestDto> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${request.exchange.producerEx}")
	private String exchange;

	@Override
	@RabbitListener(queues = "${request.routingKey.producerReq}")
	public void consumer(RequestDto t) {
		try {
				
			log.warn(t.getCpf());
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}

}
