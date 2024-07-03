package com.github.joanersoncosta.apipedido.pedido;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.apipedido.pedido.domain.Pedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class PedidoRabbitAMQPublicador {
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	private final RabbitTemplate rabbitTemplate;

	public void enviarMensagem(Pedido pedidoEnviado) {
		log.debug("[start] PedidoRabbitAMQPublicador - enviarMensagem");
		log.debug("[pedidoEnviado] {}", pedidoEnviado.toString());
		rabbitTemplate.convertAndSend(exchangeName, "", pedidoEnviado.toString());
		log.debug("[finish] PedidoRabbitAMQPublicador - enviarMensagem");
	}
}