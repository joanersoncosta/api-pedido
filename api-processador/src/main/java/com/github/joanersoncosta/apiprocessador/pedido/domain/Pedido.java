package com.github.joanersoncosta.apiprocessador.pedido.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.github.joanersoncosta.apiprocessador.handler.APIException;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;
import com.github.joanersoncosta.apiprocessador.itempedido.domain.PedidoRequest;
import com.github.joanersoncosta.apiprocessador.pedido.domain.enuns.StatusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Id
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idPedido;
	private String emailNotificacao;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ItemPedido> itens;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	private LocalDateTime dataHora;
	private BigDecimal total;

	public Pedido(PedidoRequest pedidoRequest) {
		this.idPedido = pedidoRequest.getIdPedido();
		this.emailNotificacao = pedidoRequest.getEmailNotificacao();
		this.itens = new ArrayList<>();
		this.status = pedidoRequest.getStatus();
		this.total = BigDecimal.ZERO;
		this.dataHora = pedidoRequest.getDataHora();
	}

	public void recebeItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	private void ataulizaStatus() {
		validaStatus();
		if (this.status.equals(StatusPedido.EM_PROCESSAMENTO)) {
			fechaPedido();
		}
	}

	private void validaStatus() {
		if (this.status.equals(StatusPedido.PROCESSADO)) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Este pedido já foi finalizado.");
		}
	}

	private StatusPedido fechaPedido() {
		return this.status = StatusPedido.PROCESSADO;
	}

	public Double getTotalValor() {
		Double total = itens.stream()
				.map(item -> item.getSubTotal())
				.reduce(0.0, (subtotal1, subtotal2) -> subtotal1 + subtotal2);
		return total;
	}
}