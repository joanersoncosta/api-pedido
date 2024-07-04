package com.github.joanersoncosta.apiprocessador.pedido.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;
import com.github.joanersoncosta.apiprocessador.pedido.application.service.PedidoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@RequiredArgsConstructor
public class PedidoListener {
	
	private final PedidoService pedidoService;
	
	@RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
	private void salvarPedido(PedidoRequest pedido) {
		log.info("Pedido processado:{}", pedido.toString());
		pedidoService.atualizaPedido(pedido);
	}
}