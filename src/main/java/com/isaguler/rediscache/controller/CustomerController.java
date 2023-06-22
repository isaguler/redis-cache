package com.isaguler.rediscache.controller;

import com.isaguler.rediscache.model.Customer;
import com.isaguler.rediscache.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(customerService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Customer customer) {
        customerService.update(customer);
        return ResponseEntity.ok().body("updated!");
    }
}
