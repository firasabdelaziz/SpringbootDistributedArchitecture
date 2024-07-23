package com.example.customer.controllers;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.entities.Customer;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        System.out.println("mapper"+customer);
        return customer.map(value -> ResponseEntity.ok(customerMapper.customerToCustomerDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerService.saveCustomer(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setFirstName(customerDTO.getFirstName());
            customerToUpdate.setLastName(customerDTO.getLastName());
            customerToUpdate.setEmail(customerDTO.getEmail());
            customerToUpdate.setPhoneNumber(customerDTO.getPhoneNumber());
            customerToUpdate.setOrderIds(customerDTO.getOrderIds());
            Customer updatedCustomer = customerService.saveCustomer(customerToUpdate);
            return ResponseEntity.ok(customerMapper.customerToCustomerDTO(updatedCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
