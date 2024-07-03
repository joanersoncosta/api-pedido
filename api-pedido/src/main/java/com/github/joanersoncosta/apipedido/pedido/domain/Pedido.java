package com.github.joanersoncosta.apipedido.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.joanersoncosta.apipedido.pedido.domain.enuns.StatusPedido;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pedido {
	
	private UUID idCliente;
	private UUID idProduto;
	private String emailNotificacao;
	private Integer quantidade;
	private StatusPedido status = StatusPedido.EM_PROCESSAMENTO;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHora = LocalDateTime.now();

}
