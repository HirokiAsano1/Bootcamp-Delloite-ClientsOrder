package com.Project.Clients.Repositories;

import com.Project.Clients.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Client,Long> {
}
