package com.study.springboot_project.repositories;

import com.study.springboot_project.entities.OrderItem;
import com.study.springboot_project.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
