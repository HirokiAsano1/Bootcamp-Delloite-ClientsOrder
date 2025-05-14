package com.Project.Clients.DTOs;

import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Order;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDTO {

    private Double valor;

    private LocalDateTime instante;

    private Long clienteId;

    public OrderDTO (Order order)
    {
        this.valor = order.getValor();
        this.instante = order.getInstante();
        this.clienteId = order.getClient()!= null ? order.getClient().getId(): null;
    }

    public Order convertToEntity (Order order , OrderDTO orderDTO)
    {
       order.setValor(orderDTO.getValor());
       order.setInstante(LocalDateTime.now());
       return order;
    }
}
