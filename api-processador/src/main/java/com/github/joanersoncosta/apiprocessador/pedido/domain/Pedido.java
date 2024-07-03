package com.github.joanersoncosta.apiprocessador.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.pedido.domain.enuns.StatusPedido;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "pedido")
public class Pedido {
	private UUID idPedido;
	private String emailNotificacao;
	private Produto produto;
	private Integer quantidade;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	private LocalDateTime dataHora;
	
	public UUID getIdProduto() {
		return produto.getIdProduto();
	}

	public Pedido(Produto produto2) {
	}
}