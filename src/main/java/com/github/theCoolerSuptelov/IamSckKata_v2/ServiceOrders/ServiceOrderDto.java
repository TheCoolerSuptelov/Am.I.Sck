package com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders;

import com.github.theCoolerSuptelov.IamSckKata_v2.Clients.ClientsDto;
import com.github.theCoolerSuptelov.IamSckKata_v2.Nurses.NurseDto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ServiceOrderDto implements Serializable {
  private final Date date;
  private final String number;
  private final ClientsDto clients;
  private final NurseDto nurse;

  public ServiceOrderDto(Date date, String number, ClientsDto clients, NurseDto nurse) {
    this.date = date;
    this.number = number;
    this.clients = clients;
    this.nurse = nurse;
  }

  public Date getDate() {
    return date;
  }

  public String getNumber() {
    return number;
  }

  public ClientsDto getClients() {
    return clients;
  }

  public NurseDto getNurse() {
    return nurse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServiceOrderDto entity = (ServiceOrderDto) o;
    return Objects.equals(this.date, entity.date) &&
        Objects.equals(this.number, entity.number) &&
        Objects.equals(this.clients, entity.clients) &&
        Objects.equals(this.nurse, entity.nurse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, number, clients, nurse);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "date = " + date + ", " +
        "number = " + number + ", " +
        "clients = " + clients + ", " +
        "nurse = " + nurse + ")";
  }
}
