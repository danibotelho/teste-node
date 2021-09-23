package com.danibotelho.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danibotelho.demo.entities.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
