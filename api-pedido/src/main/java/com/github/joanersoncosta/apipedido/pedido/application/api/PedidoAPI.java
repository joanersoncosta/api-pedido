package com.github.joanersoncosta.apipedido.pedido.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;
import com.github.joanersoncosta.apipedido.pedido.domain.Pedido;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos", description = "Recurso para realizar Pedidos")
@RestController
@RequestMapping("/v1/pedido")
public interface PedidoAPI {

	@Operation(summary = "Cria novo pedido", description = "Contém as operações para criar um novo pedido",
			responses = @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
			content = @Content(mediaType = "application.json", schema = @Schema(implementation = Pedido.class))))
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PedidoResponse criaPedido(@RequestBody @Validated PedidoRequest pedidoRequest);
}
