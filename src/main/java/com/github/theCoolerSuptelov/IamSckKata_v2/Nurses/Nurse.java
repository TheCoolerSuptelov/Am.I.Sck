package com.github.theCoolerSuptelov.IamSckKata_v2.Nurses;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Actor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "nurse")
public class Nurse {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "date_of_birth")
  private Integer dateOfBirth;

  @OneToOne(orphanRemoval = true)
  @JoinColumn(name = "actor_id", unique = true)
  private Actor actor;

  public Nurse() {
  }

  public Nurse(String name, String email, Integer dateOfBirth, Actor actor) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.actor = actor;
  }

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  public Integer getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Integer dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
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

}