package com.study.springboot_project.services;

import com.study.springboot_project.entities.Customer;
import com.study.springboot_project.repositories.CustomerRepository;
import com.study.springboot_project.services.exceptions.DatabaseException;
import com.study.springboot_project.services.exceptions.RecordAlreadyExistsException;
import com.study.springboot_project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static String alreadyExists = "A customer with this email already exists";
    @Autowired
    private CustomerRepository repository;

    public Customer getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(printCustomerNotFound(id)));
    }

    public List<Customer> getAll() {
        List<Customer> customerList = repository.findAll();
        if (customerList.isEmpty()) {
            throw new ResourceNotFoundException("No Customers in the database");
        }
        return customerList;
    }

    public Customer insert(Customer c) {
        Customer customer = repository.getByEmailIgnoreCase(c.getEmail());
        if (customer == null) {
            return repository.save(c);
        }
        throw new RecordAlreadyExistsException(alreadyExists);
    }

    public Customer update(Long id, Customer c) {
        Customer customerByEmail = repository.getByEmailIgnoreCase(c.getEmail());
        if (customerByEmail != null){
            throw new RecordAlreadyExistsException(alreadyExists);
        }
        try{
            Customer customer = repository.getReferenceById(id);
            customer = updateData(customer,c);
            return repository.save(customer);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(printCustomerNotFound(id));
        }
    }

    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException(printCustomerNotFound(id));
        }
        try{
            Customer c = repository.getReferenceById(id);
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }

    private Customer updateData(Customer dbCustomer, Customer newCustomerData) {
        dbCustomer.setName(newCustomerData.getName());
        dbCustomer.setEmail(newCustomerData.getEmail());
        return dbCustomer;
    }
    private String printCustomerNotFound(Long id){
        return "Customer with id " + id + " was not found";
    }
}
