package com.github.joanersoncosta.apiprocessador.pedido.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoNotificacaoRequest {
	private UUID idPedido;
	private String emailNotificacao;
	private String status;
	private LocalDateTime dataHora;
	private BigDecimal total;

	public PedidoNotificacaoRequest(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.emailNotificacao = pedido.getEmailNotificacao();
		this.status = pedido.getStatus().name();
		this.dataHora = pedido.getDataHora();
		this.total = pedido.getTotalValor();
	}
}