package com.github.joanersoncosta.apipedido.pedido.application.api.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.joanersoncosta.apipedido.pedido.domain.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PedidoResponse {
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	private StatusPedido status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHora;
	
	public PedidoResponse(PedidoRequest pedido) {
		this.emailNotificacao = pedido.getEmailNotificacao();
		this.produto = pedido.getProduto();
		this.quantidade = pedido.getQuantidade();
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
	}
}