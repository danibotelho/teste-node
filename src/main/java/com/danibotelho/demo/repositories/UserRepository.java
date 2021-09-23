package com.danibotelho.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danibotelho.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
