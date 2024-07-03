package com.github.joanersoncosta.apipedido.pedido.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apipedido.pedido.domain.Pedido;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PedidoResponse {
	private UUID idCliente;
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	private StatusPedido status;
	private LocalDateTime dataHora;
	
	public PedidoResponse(Pedido pedido) {
		this.idCliente = pedido.getIdCliente();
		this.emailNotificacao = pedido.getEmailNotificacao();
		this.produto = pedido.getProduto();
		this.quantidade = pedido.getQuantidade();
		this.status = pedido.getStatus();
		this.dataHora = pedido.getDataHora();
	}
}