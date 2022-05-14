package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrderDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

  @PostMapping("/serviceOrder")
  public String createServiceOrder(@RequestBody ServiceOrderDto serviceOrderDto, Authentication authentication){
   //var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    clientService.createServiceOrder(serviceOrderDto);
    return "OK";
  }

}
