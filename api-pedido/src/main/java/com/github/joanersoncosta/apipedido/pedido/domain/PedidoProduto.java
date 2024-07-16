package com.github.joanersoncosta.apipedido.pedido.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PedidoProduto {
	private UUID idProduto;
	private String nome;
	private BigDecimal valor;
	
	public PedidoProduto(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.valor = produto.getPreco();
	}
}