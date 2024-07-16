package com.github.joanersoncosta.apiprocessador.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${rabbitmq.exchange.notificacao}")
	private String exchangeNotificacao;
	@Value("${rabbitmq.queue.name}")
	private String queueName;
	@Value("${spring.rabbitmq.listener.simple.dead-letter-exchange}")
	private String deadLetterExchange;
	@Value("${spring.rabbitmq.listener.simple.dead-letter-routing-key}")
	private String deadLetterRoutingKey;
	
	@Bean
	public FanoutExchange pedidosExchange() {
		return new FanoutExchange(exchangeName);
	}
	
	@Bean
	public FanoutExchange notificacaoExchange() {
		return new FanoutExchange(exchangeNotificacao);
	}
	
	@Bean
	public Queue processadorQueue() {
	       return QueueBuilder.durable(queueName)
	    		    .maxLength(2)
	           		.deadLetterExchange(deadLetterExchange)
	        		.withArgument("x-message-ttl", 10000)
	           		.deadLetterRoutingKey(deadLetterRoutingKey)
	                .build();
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(processadorQueue()).to(pedidosExchange());
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> applicationReadyEventListener(RabbitAdmin rabbitAdmin){
		return event -> rabbitAdmin.initialize();
	}
	
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
