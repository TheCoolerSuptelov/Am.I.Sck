package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.Actor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "authorities")
public class Authorities {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "title")
  private String title;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "authorities_actors",
      joinColumns = @JoinColumn(name = "authorities_id"),
      inverseJoinColumns = @JoinColumn(name = "actors_id"))
  private Set<Actor> actors = new LinkedHashSet<>();

  public Set<Actor> getActors() {
    return actors;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

}