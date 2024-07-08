package com.github.joanersoncosta.apiprocessador.itempedido.domain;

import java.util.UUID;

import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "ItemPedido")
public class ItemPedido {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idItemPedido;
	@ManyToOne
	@JoinColumn(name = "id_Produto")
	private Produto produto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Pedido")
	private Pedido pedido;
	private Integer quantidade;
	
	public ItemPedido(PedidoRequest pedidoRequest, Pedido pedido) {
		this.produto = pedidoRequest.getProduto();
		this.pedido = pedido;
		this.quantidade = pedidoRequest.getQuantidade();
	}
	
	public double getSubTotal() {
		return produto.getValor() * quantidade;
	}
}