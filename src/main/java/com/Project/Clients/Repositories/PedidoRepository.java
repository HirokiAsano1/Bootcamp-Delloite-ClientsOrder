package com.Project.Clients.Repositories;

import com.Project.Clients.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByClientId(Long clientId);
}
