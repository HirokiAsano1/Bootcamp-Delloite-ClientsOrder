package com.Project.Clients.DTOs;

import com.Project.Clients.Entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ClientDTO {

    private String name;
    private String email;

    public ClientDTO (Client client)
    {
        this.name = client.getName();
        this.email = getEmail();
    }

    public Client convertToEntity(Client client ,ClientDTO clientDTO)
    {
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
}
