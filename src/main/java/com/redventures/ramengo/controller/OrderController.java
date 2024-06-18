package com.redventures.ramengo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.config.errorhandler.exceptions.CreateOrderException;
import com.redventures.ramengo.dto.CreateOrderDto;
import com.redventures.ramengo.dto.OrderDto;
import com.redventures.ramengo.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/v1/order", "/v1/orders"})
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<OrderDto> createOrder(@RequestBody String orderString) throws JsonProcessingException {

        CreateOrderDto orderDto = objectMapper.readValue(orderString, CreateOrderDto.class);

        if(orderDto.brothId() == null || orderDto.proteinId() == null){
            throw new CreateOrderException("both brothId and proteinId are required");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(orderService.createOrder(orderDto.brothId(), orderDto.proteinId()));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
