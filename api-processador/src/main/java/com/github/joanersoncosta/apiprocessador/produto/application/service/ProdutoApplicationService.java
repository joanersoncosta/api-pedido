package com.github.joanersoncosta.apiprocessador.produto.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiprocessador.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Override
	public Produto buscaProdutoPorId(UUID idProduto) {
		log.debug("[start] ProdutoApplicationService - buscaProdutoPorId");
		Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
		log.debug("[finish] ProdutoApplicationService - buscaProdutoPorId");
		return produto;
	}
}