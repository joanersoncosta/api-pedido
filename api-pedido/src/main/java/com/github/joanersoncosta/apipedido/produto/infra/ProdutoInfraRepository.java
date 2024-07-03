package com.github.joanersoncosta.apipedido.produto.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

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
		log.info("[init] UsuarioRepositoryJpaDB - salva");
		produtoExistente(produto);
		Produto NovoProduto = produtoJpaSpringRepository.save(produto);
		log.info("[finish] UsuarioRepositoryJpaDB - salva");
		return NovoProduto;
	}

	private void produtoExistente(Produto produto) {
		log.info("[init] UsuarioRepositoryJpaDB - produtoExistente");
		produtoJpaSpringRepository.findByNome(produto.getNome())
			.ifPresent(p -> {
				throw new RuntimeException("Este produto já existe");
			});
		log.info("[finish] UsuarioRepositoryJpaDB - produtoExistente");
	}

	@Override
	public Produto buscaProdutoPorId(UUID idProduto) {
		log.info("[init] UsuarioRepositoryJpaDB - buscaProdutoPorId");
		Produto produto = produtoJpaSpringRepository.findById(idProduto)
				.orElseThrow();
		log.info("[finish] UsuarioRepositoryJpaDB - buscaProdutoPorId");
		return produto;
	}
}