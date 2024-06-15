package com.redventures.ramengo.service;

import com.redventures.ramengo.config.errorhandler.exceptions.CreateOrderException;
import com.redventures.ramengo.dto.OrderDto;
import com.redventures.ramengo.entity.BrothEntity;
import com.redventures.ramengo.entity.OrderEntity;
import com.redventures.ramengo.entity.ProteinEntity;
import com.redventures.ramengo.repository.OrderRepository;
import com.redventures.ramengo.service.interfaces.BrothService;
import com.redventures.ramengo.service.interfaces.OrderService;
import com.redventures.ramengo.service.interfaces.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BrothService brothService;

    @Autowired
    ProteinService proteinService;

    @Override
    public OrderDto createOrder(Long idBroth, Long idProtein) {
        try {
            BrothEntity broth = brothService.getBrothById(idBroth);
            ProteinEntity protein = proteinService.getProteinById(idProtein);
            return createOrderDtoByOrderEntity(orderRepository.save(new OrderEntity(broth, protein)));
        } catch (Exception e) {
            throw new CreateOrderException();
        }
    }


    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(this::createOrderDtoByOrderEntity).toList();
    }

    private OrderDto createOrderDtoByOrderEntity(OrderEntity orderEntity){
        return OrderDto.builder()
                .id(orderEntity.getId())
                .image(orderEntity.getProtein().getImageRamen())
                .description(String.format("%s and %s Ramen", orderEntity.getBroth().getName(), orderEntity.getProtein().getName()))
                .total(orderEntity.getProtein().getPrice().add(orderEntity.getBroth().getPrice()))
                .build();
    }
}
