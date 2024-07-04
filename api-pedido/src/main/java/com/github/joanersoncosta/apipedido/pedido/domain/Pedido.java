package com.github.joanersoncosta.apipedido.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pedido {
	
	private UUID idPedido;
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	private StatusPedido status;
	private LocalDateTime dataHora;

	public Pedido(PedidoRequest pedidoRequest, Produto produto) {
		this.idPedido =  pedidoRequest.idPedido();
		this.emailNotificacao = pedidoRequest.emailNotificacao();
		this.produto = produto;
		this.quantidade = pedidoRequest.quantidade();
		this.status = StatusPedido.EM_PROCESSAMENTO;
		this.dataHora = LocalDateTime.now();
	}
}