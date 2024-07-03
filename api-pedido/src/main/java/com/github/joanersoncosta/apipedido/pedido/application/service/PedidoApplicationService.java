package com.github.joanersoncosta.apipedido.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apipedido.pedido.PedidoRabbitAMQPublicador;
import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;
import com.github.joanersoncosta.apipedido.pedido.domain.Pedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final PedidoRabbitAMQPublicador publicador;
	
	@Override
	public PedidoResponse enfileiraPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - enfileiraPedido");

		Pedido pedido = new Pedido(pedidoRequest);
		publicador.enviarMensagem(pedido);
		log.debug("[finish] PedidoApplicationService - enfileiraPedido");
		return new PedidoResponse(pedido);
	}
}