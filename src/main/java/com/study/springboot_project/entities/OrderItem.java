package com.study.springboot_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.study.springboot_project.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Locale;

@Entity
@Table(name = "tb_order_item")
@JsonPropertyOrder({"product", "recordedProductPrice","quantity","subtotal"})
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Double price;
    private Integer quantity;

    public OrderItem(){}
    public OrderItem(Order order, Product product, Integer quantity){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        price = id.getProduct().getPrice();
    }
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public Double getSubtotal(){
        Locale.setDefault(Locale.US);
        return Double.parseDouble(String.format("%.2f", price*quantity));
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product p){
        id.setProduct(p);
    }


    public Double getRecordedProductPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
