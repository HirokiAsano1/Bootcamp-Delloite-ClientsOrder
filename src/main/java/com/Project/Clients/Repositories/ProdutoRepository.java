package com.Project.Clients.Repositories;

import com.Project.Clients.Entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
