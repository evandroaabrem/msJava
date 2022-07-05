package br.com.otima.amqp;

import br.com.otima.dto.ResponseDto;

public interface AmqpReq<T> {
    void consumer(T t);
    ResponseDto producer(T t);
}

