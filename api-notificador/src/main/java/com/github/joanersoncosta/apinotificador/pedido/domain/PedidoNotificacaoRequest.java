package com.github.joanersoncosta.apinotificador.pedido.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoNotificacaoRequest{
	private UUID idPedido;
	private String emailNotificacao;
	private String status;
	private LocalDateTime dataHora;
	private BigDecimal total;
}