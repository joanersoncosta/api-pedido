package com.github.joanersoncosta.apipedido.pedido.domain;

import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoProduto {
	private UUID idProduto;
	private String nome;
	private Double valor;
	
	public PedidoProduto(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
	}
}