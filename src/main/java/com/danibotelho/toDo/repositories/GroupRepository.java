package com.danibotelho.toDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danibotelho.toDo.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
