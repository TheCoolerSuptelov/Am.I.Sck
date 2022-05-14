package com.github.theCoolerSuptelov.IamSckKata_v2.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {
  Clients findByEmailEquals(String email);
  /** TODO
  * AOP Kafka
  */
  Clients save(Clients client);
}