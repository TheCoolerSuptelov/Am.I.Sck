package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Actor;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Clients {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = true)
  @JoinColumn(name = "actor_id", unique = true)
  private Actor actor;

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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