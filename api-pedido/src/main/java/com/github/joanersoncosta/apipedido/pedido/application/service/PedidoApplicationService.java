package com.github.joanersoncosta.apipedido.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apipedido.pedido.application.api.request.PedidoNovoRequest;
import com.github.joanersoncosta.apipedido.pedido.application.api.response.PedidoResponse;
import com.github.joanersoncosta.apipedido.pedido.domain.PedidoRequest;
import com.github.joanersoncosta.apipedido.pedido.infra.PedidoRabbitAMQPublicador;
import com.github.joanersoncosta.apipedido.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final PedidoRabbitAMQPublicador publicador;
	private final ProdutoRepository produtoRepository;
	
	@Override
	public PedidoResponse enfileiraPedido(PedidoNovoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - enfileiraPedido");
		Produto produto = produtoRepository.buscaProdutoPorId(pedidoRequest.idProduto());
		PedidoRequest pedido = new PedidoRequest(pedidoRequest, produto);
		publicador.enviarMensagem(pedido);
		log.debug("[finish] PedidoApplicationService - enfileiraPedido");
		return new PedidoResponse(pedido);
	}
}