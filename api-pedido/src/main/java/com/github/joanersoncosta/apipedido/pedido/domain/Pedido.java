package com.github.joanersoncosta.apipedido.pedido.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pedido {
	
	private String emailNotificacao;
	private PedidoProduto produto;
	private Integer quantidade;
	private StatusPedido status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHora;

	public Pedido(PedidoRequest pedidoRequest/*, Produto produto*/) {
		this.emailNotificacao = pedidoRequest.emailNotificacao();
//		this.produto = new PedidoProduto(produto);
		this.quantidade = pedidoRequest.quantidade();
		this.status = StatusPedido.EM_PROCESSAMENTO;
		this.dataHora = LocalDateTime.now();
	}
}