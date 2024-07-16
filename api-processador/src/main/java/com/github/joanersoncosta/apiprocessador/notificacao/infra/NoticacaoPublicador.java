package com.github.joanersoncosta.apiprocessador.notificacao.infra;

import com.github.joanersoncosta.apiprocessador.pedido.domain.PedidoNotificacaoRequest;

public interface NoticacaoPublicador {
	void enviarMensagem(PedidoNotificacaoRequest pedidoRequest);
}
