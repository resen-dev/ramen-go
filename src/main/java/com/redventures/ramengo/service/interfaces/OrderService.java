package com.redventures.ramengo.service.interfaces;

import com.redventures.ramengo.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(Long idBroth, Long idProtein);

    List<OrderDto> getAllOrders();
}
