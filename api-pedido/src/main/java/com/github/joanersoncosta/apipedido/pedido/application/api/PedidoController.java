package com.github.joanersoncosta.apipedido.pedido.application.api;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;
import com.github.joanersoncosta.apipedido.pedido.application.service.PedidoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PedidoController implements PedidoAPI {
	private final PedidoService pediddoService;
	
	@Override
	public PedidoResponse criaPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoController - criaPedido");
		PedidoResponse pedidoResponse= pediddoService.enfileiraPedido(pedidoRequest);
		log.debug("[finish] PedidoController - criaPedido");
		return pedidoResponse;
	}

}
