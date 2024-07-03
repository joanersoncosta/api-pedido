package com.github.joanersoncosta.apipedido.produto.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apipedido.produto.application.api.request.ProdutoRequest;
import com.github.joanersoncosta.apipedido.produto.application.api.response.ProdutoResponse;
import com.github.joanersoncosta.apipedido.produto.application.repository.ProdutoRepository;
import com.github.joanersoncosta.apipedido.produto.domain.Produto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Override
	public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
		log.debug("[start] ProdutoApplicationService - criaProduto");
		Produto produto = produtoRepository.salva(new Produto(produtoRequest));
		log.debug("[finish] ProdutoApplicationService - criaProduto");
		return new ProdutoResponse(produto);
	}
}