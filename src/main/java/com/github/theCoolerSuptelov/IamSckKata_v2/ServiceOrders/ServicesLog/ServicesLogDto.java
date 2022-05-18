package com.github.theCoolerSuptelov.IamSckKata_v2.ServicesLog;

import com.github.theCoolerSuptelov.IamSckKata_v2.Clients.ClientsDto;
import com.github.theCoolerSuptelov.IamSckKata_v2.Nurses.NurseDto;
import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrderDto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ServicesLogDto implements Serializable {
  private final UUID id;
  private final ClientsDto clients;
  private final NurseDto nurse;
  private final ServiceOrderDto serviceOrder;

  public ServicesLogDto(UUID id, ClientsDto clients, NurseDto nurse, ServiceOrderDto serviceOrder) {
    this.id = id;
    this.clients = clients;
    this.nurse = nurse;
    this.serviceOrder = serviceOrder;
  }

  public UUID getId() {
    return id;
  }

  public ClientsDto getClients() {
    return clients;
  }

  public NurseDto getNurse() {
    return nurse;
  }

  public ServiceOrderDto getServiceOrder() {
    return serviceOrder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServicesLogDto entity = (ServicesLogDto) o;
    return Objects.equals(this.id, entity.id) &&
        Objects.equals(this.clients, entity.clients) &&
        Objects.equals(this.nurse, entity.nurse) &&
        Objects.equals(this.serviceOrder, entity.serviceOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clients, nurse, serviceOrder);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "clients = " + clients + ", " +
        "nurse = " + nurse + ", " +
        "serviceOrder = " + serviceOrder + ")";
  }
}
