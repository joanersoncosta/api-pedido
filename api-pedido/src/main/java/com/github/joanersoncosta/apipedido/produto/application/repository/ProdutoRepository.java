package com.github.joanersoncosta.apipedido.produto.application.repository;

import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

public interface ProdutoRepository {
	Produto salva(Produto produto);
	Produto buscaProdutoPorId(UUID idProduto);
}
