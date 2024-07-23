package com.example.order.services;

import com.example.order.entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    Order saveOrder(Order order);
    void deleteOrder(Long id);

}
