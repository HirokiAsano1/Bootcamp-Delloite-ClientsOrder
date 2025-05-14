package com.Project.Clients.Repositories;

import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order,Long> {
    List<Order> findByClientId(Long clientId);

}
