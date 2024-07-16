package com.github.joanersoncosta.apiprocessador.itempedido.domain;

import java.math.BigDecimal;
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
	@JoinColumn(name = "id_produto")
	private Produto produto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	private BigDecimal preco;
	private Integer quantidade;
	
	public ItemPedido(PedidoRequest pedidoRequest, Pedido pedido, Produto produto) {
		this.produto = produto;
		this.pedido = pedido;
		this.preco = produto.getPreco();
		this.quantidade = pedidoRequest.getQuantidade();
	}
	
	public BigDecimal getSubTotal() {
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
}