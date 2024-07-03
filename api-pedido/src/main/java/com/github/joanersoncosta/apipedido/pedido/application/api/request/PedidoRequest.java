package com.github.joanersoncosta.apipedido.pedido.application.api.request;

import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.domain.ProdutoRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
		@NotNull(message = "idCliente não pode ser nulo.")
		UUID idCliente,
		@NotNull(message = "idCliente não pode ser nulo.")
		UUID idPedido,
		@NotBlank(message = "Campo Email não pode esta em branco.")
		String emailNotificacao,
		ProdutoRequest produto,
		@NotNull(message = " Digite a Quantidade.")
		Integer quantidade
		) {
}