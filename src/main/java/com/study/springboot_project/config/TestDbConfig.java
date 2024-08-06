package com.study.springboot_project.config;

import com.study.springboot_project.entities.Customer;
import com.study.springboot_project.entities.Order;
import com.study.springboot_project.entities.OrderItem;
import com.study.springboot_project.entities.Product;
import com.study.springboot_project.repositories.CustomerRepository;
import com.study.springboot_project.repositories.OrderItemRepository;
import com.study.springboot_project.repositories.OrderRepository;
import com.study.springboot_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestDbConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer("lucas", "lucas@gmail.com");
        Customer c2 = new Customer("Test", "test@gmail.com");

        customerRepository.saveAll(Arrays.asList(c1,c2));

        Product p1 = new Product("Mouse", 49.99, 878);
        Product p2 = new Product("Keyboard", 120.50, 1134);

        Order o1 = new Order(Instant.now(), c1);
        Order o2 = new Order(Instant.now(), c2);

        OrderItem orderItem1 = new OrderItem(o1, p1, 3);
        OrderItem orderItem2 = new OrderItem(o1, p2, 1);

        OrderItem orderItem3 = new OrderItem(o2, p1, 5);

        productRepository.saveAll(Arrays.asList(p1,p2));
        customerRepository.saveAll(Arrays.asList(c1,c2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
        orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3));

    }
}
