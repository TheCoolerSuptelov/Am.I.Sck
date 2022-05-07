package com.github.theCoolerSuptelov.IamSckKata_v2.Utils;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "actor")
public class Actor {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  @NotNull
  private String email;

  @ManyToMany(mappedBy = "actors")
  private Set<Authorities> authoritieses = new LinkedHashSet<>();

  @Column(name = "password")
  @NotNull
  private String password;

  public Actor(String name, String email, Set<Authorities> authoritieses, String password) {
    this.name = name;
    this.email = email;
    this.authoritieses = authoritieses;
    this.password = password;
  }

  public Actor(String name, String email, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Actor() {
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Authorities> getAuthoritieses() {
    return authoritieses;
  }

  public void setAuthoritieses(Set<Authorities> authoritieses) {
    this.authoritieses = authoritieses;
  }
  public void addAuthorities(Authorities authorities){
    this.authoritieses.add(authorities);
  }
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Actor actor = (Actor) o;
    return id != null && Objects.equals(id, actor.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}