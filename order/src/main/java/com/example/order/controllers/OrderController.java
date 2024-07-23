package com.example.order.controllers;

import com.example.order.Client.CustomerClient;
import com.example.order.dto.CustomerDTO;
import com.example.order.dto.OrderDTO;
import com.example.order.entities.Order;
import com.example.order.mappers.OrderMapper;
import com.example.order.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Autowired
    private CustomerClient customerClient; // Inject the Feign Client

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(orderMapper::orderToOrderDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(value -> ResponseEntity.ok(orderMapper.orderToOrderDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.orderDTOToOrder(orderDTO);
        System.out.println("orderDTO"+order);
        Order savedOrder = orderService.saveOrder(order);
        return orderMapper.orderToOrderDTO(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        Optional<Order> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            orderToUpdate.setOrderDate(orderDTO.getOrderDate());
            orderToUpdate.setOrderStatus(orderDTO.getOrderStatus());
            orderToUpdate.setOrderTotal(orderDTO.getOrderTotal());
            orderToUpdate.setCustomerId(orderDTO.getCustomerId());
            Order updatedOrder = orderService.saveOrder(orderToUpdate);
            return ResponseEntity.ok(orderMapper.orderToOrderDTO(updatedOrder));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id){
        CustomerDTO customer = customerClient.getCustomerById(id);
        if ( customer == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/Customer/Rest/{id}")
    public CustomerDTO getCustomerRestById(@PathVariable String id){
        return restTemplate.getForObject("http://localhost:8889/api/customers/"+id,CustomerDTO.class);
    }

}