package br.com.otima.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigurationExchangeQueue {

    ////////////////////////Atendimento        
    @Value("${request.exchange.producerEx}")
    private String exchangeEx;  
    
    @Value("${request.routing-key.producerReq}")
    private String queueReq;
    
    @Value("${request.dead-letter.producerReq}")
    private String deadLetterReq; 

    
    
    @Bean
    DirectExchange exchangeEql() {
        return new DirectExchange(exchangeEx);
    }
    
    
    Queue queueReq() {
        return  QueueBuilder.durable(queueReq)
                .deadLetterExchange(exchangeEx)
                .deadLetterRoutingKey(deadLetterReq)
                .build();
    }  
    
    @Bean
    public Binding bindingQueueReq() {
        return BindingBuilder.bind(queueReq())
                .to(exchangeEql()).with(queueReq);
    }  
    
    
    @Bean
    Queue deadLetter() {
        return QueueBuilder.durable(deadLetterReq)
                .deadLetterExchange(exchangeEx)
                .deadLetterRoutingKey(queueReq)
                .build();
    }

    
    @Bean
    public Binding bindingDeadLetter() {
        return BindingBuilder.bind(deadLetter())
                .to(exchangeEql()).with(deadLetterReq);
    }
    
    
    
}
