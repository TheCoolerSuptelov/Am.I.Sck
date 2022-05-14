package com.github.theCoolerSuptelov.IamSckKata_v2.ServiceOrders;

import org.springframework.stereotype.Service;

@Service
public class ServiceOrdersService {
   public static ServiceOrder buildServiceOrderByDto(ServiceOrderDto serviceOrderDto){
        var serviceOrder = new ServiceOrder();
        return serviceOrder;
    }
}
