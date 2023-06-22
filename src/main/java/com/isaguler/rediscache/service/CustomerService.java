package com.isaguler.rediscache.service;

import com.isaguler.rediscache.model.Customer;
import com.isaguler.rediscache.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Cacheable(value = "customer", key = "#id")
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    // [conditional update]
    @CachePut(value = "customer", key = "#customer.id", condition = "#customer.vip==true")
    public void update(Customer customer) {
        customerRepository.updateById(customer);
    }
}
