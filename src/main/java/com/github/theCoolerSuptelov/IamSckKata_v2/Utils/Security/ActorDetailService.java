package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
@Service
public class ActorDetailService implements UserDetailsService {

  protected ActorService actorService;
  public ActorDetailService(@Autowired ActorService actorService) {
    this.actorService = actorService;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Actor actorAccount = actorService.getUserByEmail(email);
    if (actorAccount == null){
      throw new UsernameNotFoundException("User with email = " + email + " doesnt found");
    }
    return new User(email,
        actorAccount.getPassword(),
        actorAccount.getAuthoritieses()
            .stream()
            .map(
                role->new SimpleGrantedAuthority(
                    (role.getTitle())
                )
            )
            .collect(Collectors.toList()));
  }
}
