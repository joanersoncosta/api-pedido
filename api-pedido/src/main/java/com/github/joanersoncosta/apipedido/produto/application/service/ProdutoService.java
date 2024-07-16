package com.github.joanersoncosta.apipedido.produto.application.service;

import com.github.joanersoncosta.apipedido.produto.application.api.request.ProdutoRequest;
import com.github.joanersoncosta.apipedido.produto.application.api.response.ProdutoResponse;

public interface ProdutoService {
	ProdutoResponse criaProduto(ProdutoRequest produtoRequest);
}
