package com.github.joanersoncosta.apiprocessador.pedido.application.repository;

import java.util.Optional;
import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;

public interface PedidoRepository {
	Pedido salva(Pedido pedido);
	Optional<Pedido> buscaPedidoPorId(UUID idPedido);
}
