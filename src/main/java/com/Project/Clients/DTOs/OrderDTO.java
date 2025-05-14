package com.Project.Clients.DTOs;

import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Order;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDTO {

    @NotNull(message = "Valor não pode ser nulo")
    @Min(value = 50, message = "O valor deve ser maior ou igual a 1")
    private Double valor;

    @NotNull(message = "O Nome Não pode ser Nulo")
    private String nomeProduto;

    @NotNull(message = "ID do cliente não pode ser nulo")
    private Long clientId;

    public OrderDTO (Order order)
    {
        this.valor = order.getValor();
        this.nomeProduto = order.getNomeProduto();
        this.clientId = order.getClient()!= null ? order.getClient().getId(): null;
    }

    public Order convertToEntity(OrderDTO orderDTO, Client client) {
        Order order = new Order();
        order.setValor(orderDTO.getValor());
        order.setClient(client);
        order.setNomeProduto(orderDTO.getNomeProduto());
        return order;
    }
}
