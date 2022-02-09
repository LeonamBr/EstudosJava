package com.leonam.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonam.aula.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
