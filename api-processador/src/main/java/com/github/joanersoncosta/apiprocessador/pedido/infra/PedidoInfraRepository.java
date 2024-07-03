package com.github.joanersoncosta.apiprocessador.pedido.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiprocessador.pedido.application.repository.PedidoRepository;
import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PedidoInfraRepository implements PedidoRepository {
	private final PedidoJpaSpringRepository  pedidoJpaSpringRepository ;

	@Override
	public Pedido salva(Pedido pedido) {
		log.debug("[init] PedidoInfraRepository - salva");
		Pedido produto = pedidoJpaSpringRepository.save(pedido);
		log.debug("[finish] PedidoInfraRepository - salva");
		return produto;
	}
	
	@Override
	public Optional<Pedido> buscaPedidoPorId(UUID idPedido) {
		log.debug("[init] PedidoInfraRepository - buscaPedidoPorId");
		Optional<Pedido> produto = pedidoJpaSpringRepository.findById(idPedido);
//				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
		log.debug("[finish] PedidoInfraRepository - buscaPedidoPorId");
		return produto;
	}
}