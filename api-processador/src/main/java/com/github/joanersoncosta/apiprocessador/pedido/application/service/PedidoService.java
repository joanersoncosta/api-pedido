package com.github.joanersoncosta.apiprocessador.pedido.application.service;

import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;

public interface PedidoService {
	void atualizaPedido(PedidoRequest pedidoRequest);
}