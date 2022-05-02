package com.github.theCoolerSuptelov.IamSckKata_v2;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.ActorDto;
import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
  ActorService actorService;
  public MainController(@Autowired ActorService actorService) {
    this.actorService = actorService;
  }
//http://localhost:8089/api/actorsList?pageNo=1&pageSize=100
  @GetMapping("/api/actorsList")
  public List<ActorDto> getActorsPage(@RequestParam int pageNo, @RequestParam int pageSize){
    return actorService.getActorsPagination(pageNo, pageSize);
  }
}
