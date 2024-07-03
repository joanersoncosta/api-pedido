package com.github.joanersoncosta.apipedido.pedido.application.api.response;

import java.time.LocalDateTime;

import com.github.joanersoncosta.apipedido.pedido.domain.Pedido;
import com.github.joanersoncosta.apipedido.pedido.domain.PedidoProduto;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PedidoResponse {
	private String emailNotificacao;
	private PedidoProduto produto;
	private Integer quantidade;
	private StatusPedido status;
	private LocalDateTime dataHora;
	
	public PedidoResponse(Pedido pedido) {
		this.emailNotificacao = pedido.getEmailNotificacao();
		this.produto = pedido.getProduto();
		this.quantidade = pedido.getQuantidade();
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
	}
}