package com.github.joanersoncosta.apipedido.produto.infra;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apipedido.handler.APIException;
import com.github.joanersoncosta.apipedido.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProdutoInfraRepository implements ProdutoRepository {
	private final ProdutoJpaSpringRepository  produtoJpaSpringRepository ;
	
	@Override
	public Produto salva(Produto produto) {
		log.debug("[init] UsuarioRepositoryJpaDB - salva");
		produtoExistente(produto);
		Produto NovoProduto = produtoJpaSpringRepository.save(produto);
		log.debug("[finish] UsuarioRepositoryJpaDB - salva");
		return NovoProduto;
	}

	private void produtoExistente(Produto produto) {
		log.debug("[init] UsuarioRepositoryJpaDB - produtoExistente");
		produtoJpaSpringRepository.findByNome(produto.getNome())
			.ifPresent(p -> {
				throw APIException.build(HttpStatus.BAD_REQUEST, "Este Produto já existe.");
			});
		log.debug("[finish] UsuarioRepositoryJpaDB - produtoExistente");
	}

	@Override
	public Produto buscaProdutoPorId(UUID idProduto) {
		log.debug("[init] UsuarioRepositoryJpaDB - buscaProdutoPorId");
		Produto produto = produtoJpaSpringRepository.findById(idProduto)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Este Produto já existe."));
		log.debug("[finish] UsuarioRepositoryJpaDB - buscaProdutoPorId");
		return produto;
	}
}