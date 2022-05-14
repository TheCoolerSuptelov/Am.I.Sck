package com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders;

import com.github.theCoolerSuptelov.IamSckKata_v2.Clients.Clients;
import com.github.theCoolerSuptelov.IamSckKata_v2.Nurses.Nurse;
import com.github.theCoolerSuptelov.IamSckKata_v2.ServicesLog.ServicesLog;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "service_order")
public class ServiceOrder {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;



  @Column(name = "date")
  private Date date;

  @Column(name = "number")
  private String number;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "clients_id")
  private Clients clients;

  @ManyToOne
  @JoinColumn(name = "nurse_id")
  private Nurse nurse;

  @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private List<ServicesLog> servicesLogs = new ArrayList<>();

  public List<ServicesLog> getServicesLogs() {
    return servicesLogs;
  }

  public void setServicesLogs(List<ServicesLog> servicesLogs) {
    this.servicesLogs = servicesLogs;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

}