package com.Project.Clients.DTOs;

import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PedidoDTO {


    private LocalDateTime dataPedido;

    private ClientDTO client;

    public PedidoDTO(Pedido pedido)
    {
        this.dataPedido = pedido.getDataPedido();
        this.client = new ClientDTO(pedido.getClient());
    }
}
