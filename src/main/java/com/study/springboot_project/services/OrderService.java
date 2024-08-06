package com.study.springboot_project.services;

import com.study.springboot_project.entities.Order;
import com.study.springboot_project.repositories.OrderRepository;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order getById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " was not found"));
    }

    public List<Order> getAll(){
        List<Order> orderList = repository.findAll();
        if(orderList.isEmpty()){
            throw new ResourceNotFoundException("No Orders in the database");
        }
        return orderList;
    }
}
