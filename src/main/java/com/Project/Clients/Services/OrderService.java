package com.Project.Clients.Services;

import com.Project.Clients.DTOs.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findByClientId(Long clientId);

    OrderDTO createOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);
}
