package com.github.joanersoncosta.apiprocessador.itempedido.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.itempedido.application.repository.ItemPedidoRepository;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemPedidoApplicationService implements ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository;
	
	@Override
	public ItemPedido salva(ItemPedido itemPedido) {
		log.debug("[start] ItemPedidoApplicationService - salva");
		ItemPedido itemAtualizado = itemPedidoRepository.salva(itemPedido);
		log.debug("[finish] ItemPedidoApplicationService - salva");
		return itemAtualizado;
	}
}