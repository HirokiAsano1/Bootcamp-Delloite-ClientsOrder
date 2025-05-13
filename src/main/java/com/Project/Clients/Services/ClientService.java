package com.Project.Clients.Services;

import com.Project.Clients.DTOs.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    List<ClientDTO> findAll();

    ClientDTO findById(Long id);

    ClientDTO insert(ClientDTO clientDTO);

    ClientDTO update(ClientDTO clientDTO,Long id);

    void delete(Long id);
}
