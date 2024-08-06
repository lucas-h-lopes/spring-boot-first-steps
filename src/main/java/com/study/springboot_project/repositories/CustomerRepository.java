package com.study.springboot_project.repositories;

import com.study.springboot_project.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
