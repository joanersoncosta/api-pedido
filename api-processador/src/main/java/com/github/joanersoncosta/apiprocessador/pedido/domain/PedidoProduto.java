package com.github.joanersoncosta.apiprocessador.pedido.domain;

import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoProduto {
	private UUID idProduto;
	private String nome;
	private Double valor;
}