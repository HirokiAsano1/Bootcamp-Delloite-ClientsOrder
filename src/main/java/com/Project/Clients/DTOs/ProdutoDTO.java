package com.Project.Clients.DTOs;

import com.Project.Clients.Entities.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private String name;

    private String descricao;

    private Double preco;

    public ProdutoDTO(Produto produto)
    {
        this.name = produto.getName();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }
}
