package com.example.customer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerConsumerService {
    @KafkaListener(topics = "order_topic", groupId = "customer-group")
    public void consume(String message) {
        try {
            System.out.println("Received message: " + message);
            // Process the message here
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

}
