package com.github.joanersoncosta.apiprocessador.notificacao.infra;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class NotificacaoRabbitAMQPublicador implements NoticacaoPublicador{
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	private final RabbitTemplate rabbitTemplate;
	
	@Override
	public void enviarMensagem(String mensgaem) {
		log.debug("[start] NotificacaoRabbitAMQPublicador - enviarMensagem");
		rabbitTemplate.convertAndSend(exchangeName, "", mensgaem);
		log.debug("[finish] NotificacaoRabbitAMQPublicador - enviarMensagem");
	}
}