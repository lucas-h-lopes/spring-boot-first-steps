package com.study.springboot_project.services;

import com.study.springboot_project.entities.Customer;
import com.study.springboot_project.repositories.CustomerRepository;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found"));
    }

    public List<Customer> getAll(){
        List<Customer> customerList = repository.findAll();
        if(customerList.isEmpty()){
            throw new ResourceNotFoundException("No Customers in the database");
        }
        return customerList;
    }
}
