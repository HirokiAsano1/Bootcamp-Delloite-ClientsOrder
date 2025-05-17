package com.Project.Clients.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class ProdutoPedido {

    @EmbeddedId
    private ProdutoPedidoID id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name= "pedido_id")
    private Pedido pedido;

    private Integer quantity;
}
