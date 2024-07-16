package com.github.joanersoncosta.apiprocessador.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDeadLetterConfig {

	@Value("${spring.rabbitmq.listener.simple.dead-letter-exchange}")
	private String deadLetterExchange;
	@Value("${rabbitmq.queue.dead-letter}")
	private String queueName;
	@Value("${spring.rabbitmq.listener.simple.dead-letter-routing-key}")
	private String deadLetterRoutingKey;

	@Bean
    public Queue mainQueue() {
        return QueueBuilder.durable(queueName)
                 .build();
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(deadLetterExchange);
    }

    @Bean
    public Binding bindingDeadLetterQueue() {
        return BindingBuilder.bind(mainQueue())
                .to(deadLetterExchange())
                .with(deadLetterRoutingKey);
    }
}