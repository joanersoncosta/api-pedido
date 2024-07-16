package com.github.joanersoncosta.apinotificador.pedido.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.apinotificador.email.application.service.EmailService;
import com.github.joanersoncosta.apinotificador.pedido.domain.PedidoNotificacaoRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@RequiredArgsConstructor
public class PedidoListener {
	private final EmailService emailService;

	@RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
	public void enviarNotificacao(PedidoNotificacaoRequest pedidoRequest) throws InterruptedException {
		log.debug("[start] PedidoListener - enviarNotificacao");
		Thread.sleep(5000);
		log.info("Notificação gerada: {}", pedidoRequest.toString());
		emailService.enviarEmail(pedidoRequest);
		log.debug("[finish] PedidoListener - enviarNotificacao");
	}
}