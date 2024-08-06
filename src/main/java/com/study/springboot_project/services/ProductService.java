package com.study.springboot_project.services;

import com.study.springboot_project.entities.Product;
import com.study.springboot_project.repositories.ProductRepository;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product getById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " was not found"));
    }

    public List<Product> getAll(){
        List<Product> productList = repository.findAll();
        if(productList.isEmpty()){
            throw new ResourceNotFoundException("No Products in the database");
        }
        return productList;
    }
}
