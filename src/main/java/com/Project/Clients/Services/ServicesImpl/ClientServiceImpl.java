package com.Project.Clients.Services.ServicesImpl;

import com.Project.Clients.DTOs.ClientDTO;
import com.Project.Clients.DTOs.PedidoDTO;
import com.Project.Clients.Entities.Client;
import com.Project.Clients.Entities.Pedido;
import com.Project.Clients.Repositories.ClientRepository;
import com.Project.Clients.Repositories.PedidoRepository;
import com.Project.Clients.Services.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientDTO::new).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com id " + id + " não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional
    @Override
    public ClientDTO insert(ClientDTO clientDTO) {
      Client client = new Client();
      clientDTO.convertToEntity(client,clientDTO);
      client = clientRepository.save(client);
      return new ClientDTO(client);
    }

    @Transactional
    @Override
    public ClientDTO update(ClientDTO clientDTO, Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com id " + id + " não encontrado."));
        clientDTO.convertToEntity(client,clientDTO);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO, Long clientId) {
        Client cliente = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido pedido = new Pedido();
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setClient(cliente);
        pedido = pedidoRepository.save(pedido);
        return  new PedidoDTO(pedido);
    }

    @Override
    public List<PedidoDTO> FindPedidos(Long clientId) {
        List<Pedido> pedidos = pedidoRepository.findByClientId(clientId);
        return pedidos.stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }
}
