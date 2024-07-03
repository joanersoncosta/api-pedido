package com.github.joanersoncosta.apipedido.produto.application.repository;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

public interface ProdutoRepository {
	Produto salva(Produto produto);
}
