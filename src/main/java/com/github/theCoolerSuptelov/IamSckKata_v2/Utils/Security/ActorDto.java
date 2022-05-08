package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ActorDto implements Serializable {
  private final UUID id;
  private final String name;
  private final String email;
  private final Set<AuthoritiesDto> authoritieses;

  public static ActorDto buildActorDtoByActor(Actor actor){
    return new ActorDto(
        actor.getId(),
        actor.getName(),
        actor.getEmail(),
        actor.getAuthoritieses().stream().map(
            AuthoritiesDto::buildAuthoritiesDtoByAAuthorities).collect(Collectors.toSet())
    );
  }
  public ActorDto(UUID id, String name, String email, Set<AuthoritiesDto> authoritieses) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.authoritieses = authoritieses;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Set<AuthoritiesDto> getAuthoritieses() {
    return authoritieses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ActorDto entity = (ActorDto) o;
    return Objects.equals(this.id, entity.id) &&
        Objects.equals(this.name, entity.name) &&
        Objects.equals(this.email, entity.email) &&
        Objects.equals(this.authoritieses, entity.authoritieses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, authoritieses);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "name = " + name + ", " +
        "email = " + email + ", " +
        "authoritieses = " + authoritieses + ")";
  }
}
