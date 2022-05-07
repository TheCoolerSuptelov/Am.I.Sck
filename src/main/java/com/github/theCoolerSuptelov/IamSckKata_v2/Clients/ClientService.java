package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Actor;
import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
