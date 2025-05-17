package com.Project.Clients.Controllers;

import com.Project.Clients.DTOs.ClientDTO;
import com.Project.Clients.DTOs.PedidoDTO;
import com.Project.Clients.Entities.Pedido;
import com.Project.Clients.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<ClientDTO>> listarClientes()
    {
        List<ClientDTO> clientes= clientService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> encontrarCliente(@PathVariable Long id)
    {
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> criarCliente(@RequestBody ClientDTO clientDTO)
    {
        clientDTO = clientService.insert(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> editarCliente(@RequestBody ClientDTO clientDTO,@PathVariable Long id)
    {
        clientDTO = clientService.update(clientDTO,id);
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> excluirClient(@PathVariable Long id)
    {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<PedidoDTO> criarPedido(@PathVariable Long clientId, @RequestBody PedidoDTO pedidoDTO)
    {
        PedidoDTO pedido = clientService.createPedido(pedidoDTO,clientId);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/pedidos/{clientId}")
    public ResponseEntity<List<PedidoDTO>> listarPedidos(@PathVariable Long clientId)
    {
        List<PedidoDTO> pedidos = clientService.FindPedidos(clientId);
        return ResponseEntity.ok(pedidos);
    }


}
