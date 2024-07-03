package com.github.joanersoncosta.apiprocessador.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.pedido.application.repository.PedidoRepository;
import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;
import com.github.joanersoncosta.apiprocessador.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;

	@Override
	public void atualizaPedido(Pedido pedido) {
		log.debug("[start] PedidoApplicationService - atualizaPedido");
		Produto produto = produtoRepository.buscaProdutoPorId(pedido.getIdProduto());
		Pedido pedidoAtualizado = pedidoRepository.buscaPedidoPorId(pedido.getIdPedido()).map(p -> {
//			        p.setProduto(produto);
			return pedidoRepository.salva(p);
		}).orElseGet(() -> {
			return pedidoRepository.salva(new Pedido(produto));
		});
		log.debug("[finish] PedidoApplicationService - atualizaPedido");
	}
}