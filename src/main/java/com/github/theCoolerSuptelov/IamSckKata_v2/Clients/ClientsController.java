package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients/v1")
public class ClientsController {

  ClientService clientService;

  public ClientsController(@Autowired ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/{email}")
  @Secured("ROLE_ADMIN")
  public ClientsDto getClientByEmail(@PathVariable String email){
    Clients foundClient = clientService.getClientByEmail(email);
    if (foundClient==null){
      return null;
    }
    return new ClientsDto(foundClient);
  }
  @PostMapping("/RegisterNewClient")
  public ClientsDto registerClient(@RequestBody @Valid ClientsDto clientsDto) throws ResponseStatusException {
    return new ClientsDto(clientService.createClient(clientsDto));
  }

}
