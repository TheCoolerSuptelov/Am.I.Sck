package com.github.theCoolerSuptelov.IamSckKata_v2.Nurses;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.ActorDto;

import java.io.Serializable;
import java.util.Objects;

public class NurseDto implements Serializable {
  private final String name;
  private final String email;
  private final Integer dateOfBirth;
  private final ActorDto actor;

  public NurseDto(String name, String email, Integer dateOfBirth, ActorDto actor) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.actor = actor;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Integer getDateOfBirth() {
    return dateOfBirth;
  }

  public ActorDto getActor() {
    return actor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NurseDto entity = (NurseDto) o;
    return Objects.equals(this.name, entity.name) &&
        Objects.equals(this.email, entity.email) &&
        Objects.equals(this.dateOfBirth, entity.dateOfBirth) &&
        Objects.equals(this.actor, entity.actor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, dateOfBirth, actor);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "name = " + name + ", " +
        "email = " + email + ", " +
        "dateOfBirth = " + dateOfBirth + ", " +
        "actor = " + actor + ")";
  }
}
