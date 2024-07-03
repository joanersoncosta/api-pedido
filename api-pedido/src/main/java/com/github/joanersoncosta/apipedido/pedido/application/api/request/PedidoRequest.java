package com.github.joanersoncosta.apipedido.pedido.application.api.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
		@NotNull(message = "idCliente não pode ser nulo.")
		UUID idCliente,
		@NotNull(message = "idCliente não pode ser nulo.")
		UUID idPedido,
		@NotNull(message = "idCliente não pode ser nulo.")
		UUID idProduto,
		@NotBlank(message = "Campo Email não pode esta em branco.")
		String emailNotificacao,
		@NotNull(message = " Digite a Quantidade.")
		Integer quantidade
		) {
}