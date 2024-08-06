package com.study.springboot_project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name: Can't be blank")
    @Size(min = 2, max = 40, message = "Name: Must have 2 to 40 characters")
    private String name;
    @NotNull(message = "Price: Can't be null")
    @Min(value = 1, message = "Price: Can't be lower than 1")
    private Double price;
    @NotNull(message = "In_stock: Can't be null")
    @Min(value = 0, message = "In_stock: Can't be a negative number")
    private Integer in_stock;

    public Product(String name, Double price, Integer in_stock){
        this.name = name;
        this.price = price;
        this.in_stock = in_stock;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Integer in_stock) {
        this.in_stock = in_stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
