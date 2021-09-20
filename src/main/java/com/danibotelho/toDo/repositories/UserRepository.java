package com.danibotelho.toDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danibotelho.toDo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
