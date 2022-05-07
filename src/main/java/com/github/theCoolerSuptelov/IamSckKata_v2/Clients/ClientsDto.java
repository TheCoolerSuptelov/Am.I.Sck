package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ClientsDto implements Serializable {
  @NotNull
  private final String name;
  @NotNull
  private final String email;
  private final String address;
  private final Date dateOfBirth;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  //  @JsonIgnore
//  private final char[] password;
  private String password;
  public ClientsDto(String name, String email, String address, Date dateOfBirth, String password) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.dateOfBirth = dateOfBirth;
    this.password = password;
  }
  ClientsDto(Clients client){
    this.name = client.getName();
    this.address = client.getAddress();
    this.dateOfBirth = client.getDateOfBirth();
    this.email = client.getEmail();
    this.password = client.getActor().getPassword();
  }
  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientsDto entity = (ClientsDto) o;
    return Objects.equals(this.name, entity.name) &&
        Objects.equals(this.email, entity.email) &&
        Objects.equals(this.address, entity.address) &&
        Objects.equals(this.dateOfBirth, entity.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, address, dateOfBirth);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "name = " + name + ", " +
        "email = " + email + ", " +
        "address = " + address + ", " +
        "dateOfBirth = " + dateOfBirth + ")";
  }
}
