package com.isaguler.rediscache.repository;

import com.isaguler.rediscache.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> getAll() {
        return products.values().stream().toList();
    }

    public Product getById(Long id) {
        return products.get(id);
    }

    public void updateById(Product product) {
        products.put(product.getId(), product);
    }
}
