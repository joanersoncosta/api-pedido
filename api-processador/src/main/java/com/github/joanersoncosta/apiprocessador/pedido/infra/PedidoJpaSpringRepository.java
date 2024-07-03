package com.github.joanersoncosta.apiprocessador.pedido.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.apiprocessador.pedido.domain.Pedido;

public interface PedidoJpaSpringRepository extends JpaRepository<Pedido, UUID>{
}
