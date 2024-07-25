package com.example.customer.services;

import com.example.customer.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(String id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(String id);
}
