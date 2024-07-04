package com.github.joanersoncosta.apiprocessador.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.itempedido.application.service.ItemPedidoService;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;
import com.github.joanersoncosta.apiprocessador.pedido.application.repository.PedidoRepository;
import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;
import com.github.joanersoncosta.apiprocessador.produto.application.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;
	private final ItemPedidoService itemPedidoService;

	@Override
	public void atualizaPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - atualizaPedido");
//		Produto produto = produtoRepository.buscaProdutoPorId(pedidoRequest.getProduto().getIdProduto());
		Pedido pedido = detalhaPedido(pedidoRequest);
		ItemPedido itemPedido = itemPedidoService.salva(new ItemPedido(pedidoRequest, pedido));
        pedido.recebeItem(itemPedido);
        pedidoRepository.salva(pedido);
		log.debug("[finish] PedidoApplicationService - atualizaPedido");
	}

	private Pedido detalhaPedido(PedidoRequest pedidoRequest) {
		Pedido pedido = pedidoRepository.buscaPedidoPorId(pedidoRequest.getIdPedido()).map(p -> {
			return p;
		}).orElseGet(() -> {
			return pedidoRepository.salva(new Pedido(pedidoRequest));
		});
		return pedido;
	}
}