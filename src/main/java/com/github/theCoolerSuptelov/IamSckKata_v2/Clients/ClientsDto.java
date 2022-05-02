package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ClientsDto implements Serializable {
  private final String name;
  private final String email;
  private final String address;
  private final Date dateOfBirth;

  public ClientsDto(String name, String email, String address, Date dateOfBirth) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.dateOfBirth = dateOfBirth;
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
