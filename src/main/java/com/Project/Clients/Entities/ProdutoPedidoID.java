package com.Project.Clients.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class ProdutoPedidoID {

    @Column(name = "produto_id")
    private Long produtoId;


    @Column(name = "pedido_id")
    private Long pedidoId;
}
