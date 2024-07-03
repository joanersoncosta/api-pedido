package com.github.joanersoncosta.apipedido.produto.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.apipedido.produto.domain.Produto;

public interface ProdutoJpaSpringRepository extends JpaRepository<Produto, UUID>{

}
