package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class AuthoritiesDto implements Serializable {
  private final UUID id;
  private final String title;

  public AuthoritiesDto(UUID id, String title) {
    this.id = id;
    this.title = title;
  }
  public static AuthoritiesDto buildAuthoritiesDtoByAAuthorities(Authorities authorities){
    return new AuthoritiesDto(authorities.getId(), authorities.getTitle());
  }
  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AuthoritiesDto entity = (AuthoritiesDto) o;
    return Objects.equals(this.id, entity.id) &&
        Objects.equals(this.title, entity.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "title = " + title + ")";
  }
}
