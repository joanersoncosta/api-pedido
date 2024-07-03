package com.github.joanersoncosta.apiprocessador.produto.application.repository;

import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

public interface ProdutoRepository {
	Produto buscaProdutoPorId(UUID idProduto);
}
