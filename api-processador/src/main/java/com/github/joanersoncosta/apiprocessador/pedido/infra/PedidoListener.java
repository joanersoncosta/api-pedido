package com.github.joanersoncosta.apiprocessador.pedido.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.apiprocessador.handler.APIException;
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
	public void salvarPedido(PedidoRequest pedido) throws InterruptedException {
		Thread.sleep(5000);		
		log.info("Pedido Recebido: {}", pedido.toString());
	    try {
	        pedidoService.atualizaPedido(pedido);
	    } catch (Exception e) {
	        log.error("Erro ao processar a mensagem: {}", e.getMessage(), e);
	        throw APIException.build(HttpStatus.BAD_REQUEST, "Erro ao processar a mensagem."); // Não reenvia a mensagem para a fila
	    }
	}
}