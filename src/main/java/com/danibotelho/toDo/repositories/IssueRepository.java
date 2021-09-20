package com.danibotelho.toDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danibotelho.toDo.models.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
