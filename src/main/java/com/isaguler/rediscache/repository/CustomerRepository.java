package com.isaguler.rediscache.repository;

import com.isaguler.rediscache.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomerRepository {

    ConcurrentHashMap<Long, Customer> customers = new ConcurrentHashMap<>();

    public void add(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public List<Customer> getAll() {
        return customers.values().stream().toList();
    }

    public Customer getById(Long id) {
        return customers.get(id);
    }

    public void updateById(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
