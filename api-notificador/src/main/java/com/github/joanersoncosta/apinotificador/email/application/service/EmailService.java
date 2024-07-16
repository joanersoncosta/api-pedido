package com.github.joanersoncosta.apinotificador.email.application.service;

import com.github.joanersoncosta.apinotificador.pedido.domain.PedidoNotificacaoRequest;

public interface EmailService {
	void enviarEmail(PedidoNotificacaoRequest pedidoRequest);
}
