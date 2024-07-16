package com.github.joanersoncosta.apinotificador.email.application.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apinotificador.pedido.domain.PedidoNotificacaoRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailApplicationService implements EmailService{
	private final JavaMailSender mailSender;

	@Override
	public void enviarEmail(PedidoNotificacaoRequest pedidoRequest) {
		log.debug("[start] EmailApplicationService - enviarEmail");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("api-pedido@company.com");
		simpleMailMessage.setTo(pedidoRequest.getEmailNotificacao());
		simpleMailMessage.setSubject("Pedido de Compra");
		simpleMailMessage.setText(gerarMensagemPedido(pedidoRequest));
		mailSender.send(simpleMailMessage);
		log.debug("[finish] EmailApplicationService - enviarEmail");
	}

	private String gerarMensagemPedido(PedidoNotificacaoRequest pedidoRequest) {
		log.debug("[start] EmailApplicationService - gerarMensagemPedido");
		String idPedido = String.valueOf(pedidoRequest.getIdPedido());
		String valor = String.valueOf(pedidoRequest.getTotal());
		String status = pedidoRequest.getStatus();
		String mensage = String.format("Olá, seu pedido de nº %s no valor de $R %s, foi processado com sucesso.Status: %s", idPedido, valor, status);
		log.debug("[finish] EmailApplicationService - gerarMensagemPedido");
		return mensage;
	}
}