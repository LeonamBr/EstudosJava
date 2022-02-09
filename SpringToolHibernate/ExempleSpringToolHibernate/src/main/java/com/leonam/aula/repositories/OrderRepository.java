package com.leonam.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.aula.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
