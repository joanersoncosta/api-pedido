package com.github.joanersoncosta.apiprocessador.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.itempedido.application.service.ItemPedidoService;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;
import com.github.joanersoncosta.apiprocessador.notificacao.infra.NoticacaoPublicador;
import com.github.joanersoncosta.apiprocessador.pedido.application.repository.PedidoRepository;
import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;
import com.github.joanersoncosta.apiprocessador.pedido.domain.PedidoNotificacaoRequest;
import com.github.joanersoncosta.apiprocessador.produto.application.service.ProdutoService;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final PedidoRepository pedidoRepository;
	private final ItemPedidoService itemPedidoService;
	private final ProdutoService produtoService;
	private final NoticacaoPublicador noticacaoPublicador;

	@Override
	public void atualizaPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - atualizaPedido");
		Produto produto = produtoService.buscaProdutoPorId(pedidoRequest.getIdProduto());
		Pedido pedido = detalhaPedido(pedidoRequest);
		ItemPedido itemPedido = itemPedidoService.salva(new ItemPedido(pedidoRequest, pedido, produto));
		pedido.recebeItem(itemPedido);
		pedidoRepository.salva(pedido);
		noticacaoPublicador.enviarMensagem(new PedidoNotificacaoRequest(pedido));
		log.debug("[finish] PedidoApplicationService - atualizaPedido");
	}

	private Pedido detalhaPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - detalhaPedido");
		Pedido pedido = pedidoRepository.buscaPedidoPorId(pedidoRequest.getIdPedido()).map(p -> {
			p.getItens().size();
			return p;
		}).orElseGet(() -> {
			return pedidoRepository.salva(new Pedido(pedidoRequest));
		});
		log.debug("[finish] PedidoApplicationService - detalhaPedido");
		return pedido;
	}
}