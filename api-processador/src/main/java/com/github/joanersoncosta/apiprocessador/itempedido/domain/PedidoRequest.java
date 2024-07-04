package com.github.joanersoncosta.apiprocessador.itempedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoRequest {
	
	private UUID idPedido;
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	private StatusPedido status;
	private LocalDateTime dataHora;
}