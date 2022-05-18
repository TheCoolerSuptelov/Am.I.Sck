package com.github.theCoolerSuptelov.IamSckKata_v2.ServicesLog;

import com.github.theCoolerSuptelov.IamSckKata_v2.Clients.Clients;
import com.github.theCoolerSuptelov.IamSckKata_v2.Nurses.Nurse;
import com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders.ServiceOrder;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "services_log")
public class ServicesLog {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "clients_id")
  private Clients clients;

  @ManyToOne
  @JoinColumn(name = "nurse_id")
  private Nurse nurse;

  @ManyToOne
  @JoinColumn(name = "service_order_id")
  private ServiceOrder serviceOrder;

  public ServiceOrder getServiceOrder() {
    return serviceOrder;
  }

  public void setServiceOrder(ServiceOrder serviceOrder) {
    this.serviceOrder = serviceOrder;
  }

  public Nurse getNurse() {
    return nurse;
  }

  public void setNurse(Nurse nurse) {
    this.nurse = nurse;
  }

  public Clients getClients() {
    return clients;
  }

  public void setClients(Clients clients) {
    this.clients = clients;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

}