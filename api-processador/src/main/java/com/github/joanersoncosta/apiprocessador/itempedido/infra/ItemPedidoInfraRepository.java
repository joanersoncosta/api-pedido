package com.github.joanersoncosta.apiprocessador.itempedido.infra;

import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiprocessador.itempedido.application.repository.ItemPedidoRepository;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ItemPedidoInfraRepository implements ItemPedidoRepository {
	private final ItemPedidoJpaSpringRepository  itemPedidoJpaSpringRepository ;

	@Override
	public ItemPedido salva(ItemPedido itemPedido) {
		log.debug("[init] ItemPedidoInfraRepository - salva");
		ItemPedido item = itemPedidoJpaSpringRepository.save(itemPedido);
		log.debug("[finish] ItemPedidoInfraRepository - salva");
		return item;
	}
}