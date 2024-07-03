package com.github.joanersoncosta.apipedido.produto.application.api;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;
import com.github.joanersoncosta.apipedido.pedido.application.service.PedidoService;
import com.github.joanersoncosta.apipedido.produto.application.api.request.ProdutoRequest;
import com.github.joanersoncosta.apipedido.produto.application.api.response.ProdutoResponse;
import com.github.joanersoncosta.apipedido.produto.application.service.ProdutoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
	private final ProdutoService produtoService;

	@Override
	public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
		log.debug("[start] PedidoController - criaPedido");
		ProdutoResponse produtoResponse= produtoService.criaProduto(produtoRequest);
		log.debug("[finish] PedidoController - criaPedido");
		return produtoResponse;
	}
}