package com.github.joanersoncosta.apiprocessador.itempedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.joanersoncosta.apiprocessador.pedido.domain.enuns.StatusPedido;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoRequest {
	
	private UUID idPedido;
	private String emailNotificacao;
	private UUID idProduto;
	private Integer quantidade;
	private StatusPedido status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dataHora;

	@JsonCreator
	public PedidoRequest(@JsonProperty("idPedido") UUID idPedido,
	                     @JsonProperty("emailNotificacao") String emailNotificacao,
	                     @JsonProperty("idProduto") UUID idProduto,
	                     @JsonProperty("quantidade") Integer quantidade,
	                     @JsonProperty("status") StatusPedido status,
	                     @JsonProperty("dataHora") LocalDateTime dataHora) {
		this.idPedido = idPedido;
		this.emailNotificacao = emailNotificacao;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.status = status;
		this.dataHora = dataHora;
	}
}