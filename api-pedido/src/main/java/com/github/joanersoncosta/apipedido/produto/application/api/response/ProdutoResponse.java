package com.github.joanersoncosta.apipedido.produto.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProdutoResponse {
	private UUID idProduto;
	
	public ProdutoResponse(Produto produto) {
		this.idProduto = produto.getIdProduto();
	}
}
