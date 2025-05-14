package com.Project.Clients.Controllers;

import com.Project.Clients.DTOs.OrderDTO;
import com.Project.Clients.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{clientId}")
    public ResponseEntity<List<OrderDTO>> listarPedidos(@PathVariable Long clientId) {
        List<OrderDTO> orderDTOS = orderService.findByClientId(clientId);
        return ResponseEntity.ok(orderDTOS);
    }


    @PostMapping
    public ResponseEntity<OrderDTO> criarPedido(@RequestBody OrderDTO orderDTO)
    {
        OrderDTO orderDto = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id)
    {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
