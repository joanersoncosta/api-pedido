package com.github.joanersoncosta.apiprocessador.produto.infra;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiprocessador.handler.APIException;
import com.github.joanersoncosta.apiprocessador.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProdutoInfraRepository implements ProdutoRepository {
	private final ProdutoJpaSpringRepository  produtoJpaSpringRepository ;

	@Override
	public Produto buscaProdutoPorId(UUID idProduto) {
		log.debug("[init] ProdutoInfraRepository - buscaProdutoPorId");
		Produto produto = produtoJpaSpringRepository.findById(idProduto)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Este Produto já existe."));
		log.debug("[finish] ProdutoInfraRepository - buscaProdutoPorId");
		return produto;
	}
}