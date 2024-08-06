package com.study.springboot_project.config;

import com.study.springboot_project.entities.Customer;
import com.study.springboot_project.entities.Product;
import com.study.springboot_project.repositories.CustomerRepository;
import com.study.springboot_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestDbConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer("lucas", "lucas@gmail.com");
        Customer c2 = new Customer("Test", "test@gmail.com");

        customerRepository.saveAll(Arrays.asList(c1,c2));

        Product p1 = new Product("Mouse", 49.99, 2);
        Product p2 = new Product("Keyboard", 120.50, 1);

        p1.setCustomer(c1);
        p2.setCustomer(c2);

        productRepository.saveAll(Arrays.asList(p1,p2));
        customerRepository.saveAll(Arrays.asList(c1,c2));
    }
}
