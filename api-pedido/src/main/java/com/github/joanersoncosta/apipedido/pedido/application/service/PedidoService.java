package com.github.joanersoncosta.apipedido.pedido.application.service;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;

public interface PedidoService {
	PedidoResponse enfileiraPedido(PedidoRequest pedidoRequest);
}
