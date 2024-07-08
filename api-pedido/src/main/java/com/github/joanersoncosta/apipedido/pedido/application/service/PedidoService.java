package com.github.joanersoncosta.apipedido.pedido.application.service;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoNovoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;

public interface PedidoService {
	PedidoResponse enfileiraPedido(PedidoNovoRequest pedidoRequest);
}
