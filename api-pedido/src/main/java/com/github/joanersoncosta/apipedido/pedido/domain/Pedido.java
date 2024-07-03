package com.github.joanersoncosta.apipedido.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pedido {
	
	private UUID idCliente;
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	private StatusPedido status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHora;

	public Pedido(PedidoRequest pedidoRequest) {
		this.idCliente = pedidoRequest.idCliente();
		this.emailNotificacao = pedidoRequest.emailNotificacao();
		this.produto = new Produto(pedidoRequest.produto());
		this.quantidade = pedidoRequest.quantidade();
		this.status = StatusPedido.EM_PROCESSAMENTO;
		this.dataHora = LocalDateTime.now();
	}
}