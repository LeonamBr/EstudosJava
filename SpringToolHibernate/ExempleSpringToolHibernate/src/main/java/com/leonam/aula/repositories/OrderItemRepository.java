package com.leonam.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.aula.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
