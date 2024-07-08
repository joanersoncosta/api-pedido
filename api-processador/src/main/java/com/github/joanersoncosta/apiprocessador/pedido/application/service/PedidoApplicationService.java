package com.github.joanersoncosta.apiprocessador.pedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.itempedido.application.service.ItemPedidoService;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;
import com.github.joanersoncosta.apiprocessador.notificacao.infra.NoticacaoPublicador;
import com.github.joanersoncosta.apiprocessador.pedido.application.repository.PedidoRepository;
import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PedidoApplicationService implements PedidoService {
	private final PedidoRepository pedidoRepository;
	private final ItemPedidoService itemPedidoService;
	private final NoticacaoPublicador noticacaoPublicador;

	@Override
	public void atualizaPedido(PedidoRequest pedidoRequest) {
		log.debug("[start] PedidoApplicationService - atualizaPedido");
		Pedido pedido = detalhaPedido(pedidoRequest);
		ItemPedido itemPedido = itemPedidoService.salva(new ItemPedido(pedidoRequest, pedido));
		pedido.recebeItem(itemPedido);
		pedidoRepository.salva(pedido);
		noticacaoPublicador.enviarMensagem(gerarMensagemPedido(pedido));
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
	
	private String gerarMensagemPedido(Pedido pedido) {
		String idPedido = pedido.getItens().toString();
		String valor = String.valueOf(pedido.getTotalValor());
		String status = pedido.getStatus().name();
		String mensage = String.format("Olá, seu pedido de nº %s no valor de $R %s, foi processado com sucesso./nStatus: %s", idPedido, valor, status);
		return mensage;
	}
}