package com.github.joanersoncosta.apiprocessador.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.pedido.domain.enuns.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "produto")
public class Pedido {
	private UUID idPedido;
	private String emailNotificacao;
	private String produto;
	private Integer quantidade;
	private StatusPedido status;
	private LocalDateTime dataHora;
}
