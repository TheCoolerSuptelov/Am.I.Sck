package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrder;
import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrderDto;
import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrdersService;
import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.Actor;
import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {

  private final ClientsRepository clientsRepository;
  private final ActorService actorService;
  public ClientService(@Autowired ClientsRepository clientsRepository, @Autowired ActorService actorService) {
    this.clientsRepository = clientsRepository;
    this.actorService = actorService;
  }

  Clients getCurrentUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    return getClientByEmail(username);
  }

  ServiceOrder createServiceOrder(ServiceOrderDto serviceOrderDto){

    Clients curUser = getCurrentUser();
    ServiceOrder serviceOrder = ServiceOrdersService.buildServiceOrderByDto(serviceOrderDto);
    serviceOrder.setClients(curUser);
    return serviceOrder;

  }

  public Clients getClientByEmail(String email){
    return clientsRepository.findByEmailEquals(email);
  }
  public Clients createClient(ClientsDto clientsDto) throws ResponseStatusException{
    Clients client = getClientByEmail(clientsDto.getEmail());
    if (client != null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with that email already register");
    }
    Actor actor = actorService.createActorForClient(clientsDto.getName(), clientsDto.getEmail(), clientsDto.getPassword());
    return new Clients(clientsDto.getName(),
        clientsDto.getEmail(),
        clientsDto.getAddress(),
        clientsDto.getDateOfBirth(),
        actor
    );
  }

}
