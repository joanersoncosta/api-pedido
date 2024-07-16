package com.github.joanersoncosta.apipedido.produto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import com.github.joanersoncosta.apipedido.produto.application.api.request.ProdutoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Produto {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idProduto;
	private String nome;
	private BigDecimal preco;
	
	public Produto(ProdutoRequest produto) {
		this.nome = produto.nome();
		this.preco = getValorArredondado(produto);
	}

	private BigDecimal getValorArredondado(ProdutoRequest produto) {
		var valor = BigDecimal.valueOf(produto.valor());
		valor = valor.setScale(2, RoundingMode.HALF_UP);
		return valor;
	}
}