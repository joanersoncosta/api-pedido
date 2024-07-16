package com.github.joanersoncosta.apipedido.produto.application.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequest(
		@NotBlank(message = "Campo nome não pode esta em branco.")
		String nome, 
		@NotNull(message = "Campo valor não ser nulo.")
		Double valor) {
}
