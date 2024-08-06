package com.study.springboot_project.services;

import com.study.springboot_project.entities.Product;
import com.study.springboot_project.repositories.ProductRepository;
import com.study.springboot_project.services.exceptions.DatabaseException;
import com.study.springboot_project.services.exceptions.RecordAlreadyExistsException;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(printProductNotFound(id)));
    }

    public List<Product> getAll() {
        List<Product> productList = repository.findAll();
        if (productList.isEmpty()) {
            throw new ResourceNotFoundException("No Products in the database");
        }
        return productList;
    }

    public Product insert(Product p) {
        if (repository.findByNameIgnoreCase(p.getName()) != null) {
            throw new RecordAlreadyExistsException("Product '" + p.getName() + "' in the database");
        }
        return repository.save(p);
    }

    public Product update(Long id, Product p) {
        if (repository.findByNameIgnoreCase(p.getName()) != null) {
            throw new RecordAlreadyExistsException("Product '" + p.getName() + "' in the database");
        }
        try {
            Product productInDb = repository.getReferenceById(id);
            productInDb = updateData(productInDb, p);
            return repository.save(productInDb);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(printProductNotFound(id));
        }
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(printProductNotFound(id));
        }
        try {
            repository.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getLocalizedMessage());
        }

    }

    private Product updateData(Product productInDb, Product newProductData) {
        productInDb.setName(newProductData.getName());
        productInDb.setPrice(newProductData.getPrice());
        return productInDb;
    }

    private String printProductNotFound(Long id) {
        return "Product with id " + id + " was not found";
    }
}
