package com.github.joanersoncosta.apiprocessador.itempedido.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.apiprocessador.itempedido.domain.ItemPedido;

public interface ItemPedidoJpaSpringRepository extends JpaRepository<ItemPedido, UUID>{
}
