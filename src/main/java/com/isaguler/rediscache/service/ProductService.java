package com.isaguler.rediscache.service;

import com.isaguler.rediscache.model.Product;
import com.isaguler.rediscache.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Cacheable(value = "product", key = "#id")
    public Product getById(Long id) {
        log.info("product from db");
        return productRepository.getById(id);
    }

    @CachePut(value = "product", key = "#product.id")
    public void update(Product product) {
        productRepository.updateById(product);
    }

    // [clear cache without configuration]

    /*
    @CacheEvict(value = "product", allEntries = true)
    @PostConstruct
    @Scheduled(fixedRate = 1000 * 60)
    public void clearCache() {
        log.info("cache cleared for product key");
    }
    */
}
