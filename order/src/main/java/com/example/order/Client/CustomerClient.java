package com.example.order.Client;

import com.example.order.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service",url = "${customer.service.url}")
public interface CustomerClient {

    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable("id") String id );
}
