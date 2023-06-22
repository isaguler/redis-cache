package com.isaguler.rediscache;

import com.isaguler.rediscache.model.Customer;
import com.isaguler.rediscache.model.Product;
import com.isaguler.rediscache.repository.CustomerRepository;
import com.isaguler.rediscache.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class RedisCacheApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;

	public RedisCacheApplication(ProductRepository productRepository, CustomerRepository customerRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "p-1", BigDecimal.valueOf(100));
		Product product2 = new Product(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "p-1", BigDecimal.valueOf(200));
		Product product3 = new Product(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "p-1", BigDecimal.valueOf(300));

		List<Product> products = List.of(product1, product2, product3);
		for (Product p : products) {
			productRepository.add(p);
		}

		Customer customer1 = new Customer(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "c-1", true);
		Customer customer2 = new Customer(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "c-1", true);
		Customer customer3 = new Customer(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE, "c-1", true);

		List<Customer> customers = List.of(customer1, customer2, customer3);
		for (Customer c : customers) {
			customerRepository.add(c);
		}

	}
}
