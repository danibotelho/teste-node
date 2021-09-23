package com.danibotelho.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danibotelho.demo.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
