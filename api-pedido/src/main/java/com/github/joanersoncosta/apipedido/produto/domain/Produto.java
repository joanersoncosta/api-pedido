package com.github.joanersoncosta.apipedido.produto.domain;

import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Produto {
	private UUID idProduto;
	private String nome;
	private Double valor;
	
	public Produto(ProdutoRequest produto) {
		this.idProduto = UUID.randomUUID();
		this.nome = produto.nome();
		this.valor = produto.valor();
	}
}
