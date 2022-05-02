package com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, UUID> {
}