package com.github.joanersoncosta.apiprocessador.produto.application.service;

import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

public interface ProdutoService {
	Produto buscaProdutoPorId(UUID idProduto);
}
