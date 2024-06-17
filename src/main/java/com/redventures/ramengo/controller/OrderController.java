package com.redventures.ramengo.controller;


import com.redventures.ramengo.dto.CreateOrderDto;
import com.redventures.ramengo.dto.OrderDto;
import com.redventures.ramengo.service.interfaces.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@CrossOrigin(origins = "https://tech.redventures.com.br", allowedHeaders = "x-api-key")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderDto createOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(createOrderDto.brothId(), createOrderDto.proteinId()));

    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
