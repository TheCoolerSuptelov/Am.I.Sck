package com.github.theCoolerSuptelov.IamSckKata_v2.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
  protected ActorRepository actorRepository;

  public ActorService(@Autowired ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }
  public Actor getUserByEmail(String email){
    return actorRepository.findByEmailEquals(email);
  }
  public List<ActorDto> getActorsPagination(int pageNo, int pageSize){
    var pageable = PageRequest.of(pageNo-1,pageSize);
    return actorRepository.findAll(pageable).stream().map(ActorDto::buildActorDtoByActor).collect(Collectors.toList());
  }
}
