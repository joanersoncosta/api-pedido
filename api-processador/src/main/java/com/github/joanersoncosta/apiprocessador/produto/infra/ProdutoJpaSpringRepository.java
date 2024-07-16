package com.github.joanersoncosta.apiprocessador.produto.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.apiprocessador.produto.domain.Produto;

public interface ProdutoJpaSpringRepository extends JpaRepository<Produto, UUID>{
}
