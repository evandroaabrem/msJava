package br.com.otima.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigurationExchangeQueue {

    ////////////////////////Atendimento        
    @Value("${request.exchange.producerEx}")
    private String exchangeEx;  
    
    @Value("${request.routingKey.producerReq}")
    private String queueReq;
    
    @Value("${request.deadLetter.producerReq}")
    private String deadLetterReq; 

    
    
    @Bean
    DirectExchange exchangeEql() {
        return new DirectExchange(exchangeEx);
    }
    
    @Bean
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
