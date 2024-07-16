package com.github.joanersoncosta.apipedido.pedido.infra;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.apipedido.pedido.domain.PedidoRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class PedidoRabbitAMQPublicador {
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	private final RabbitTemplate rabbitTemplate;

	public void enviarMensagem(PedidoRequest pedidoEnviado) {
		log.debug("[start] PedidoRabbitAMQPublicador - enviarMensagem");
		log.debug("[pedidoEnviado] {}", pedidoEnviado.toString());
		rabbitTemplate.convertAndSend(exchangeName, "", pedidoEnviado);
		log.debug("[finish] PedidoRabbitAMQPublicador - enviarMensagem");
	}
}