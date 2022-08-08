package br.com.otima.amqp;


public interface AmqpReq<T> {
    void consumer(T t);
}

