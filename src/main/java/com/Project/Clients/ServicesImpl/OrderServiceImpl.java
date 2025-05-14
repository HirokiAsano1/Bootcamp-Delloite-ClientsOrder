package com.Project.Clients.ServicesImpl;

import com.Project.Clients.DTOs.OrderDTO;
import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Order;
import com.Project.Clients.Repositories.ClientRepository;
import com.Project.Clients.Repositories.OrderRepository;
import com.Project.Clients.Services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<OrderDTO> findByClientId(Long clientId) {
        List<Order> orders = orderRepository.findByClientId(clientId);
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        if (orderDTO.getClientId() == null) {
            throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
        }

        Client client = clientRepository.findById(orderDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Order order = orderDTO.convertToEntity(orderDTO, client);
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }
}
