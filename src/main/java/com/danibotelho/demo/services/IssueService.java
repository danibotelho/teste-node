package com.danibotelho.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danibotelho.demo.entities.Issue;
import com.danibotelho.demo.repositories.IssueRepository;


@Service
public class IssueService {

	@Autowired
	private IssueRepository  repository;
	
		
	public List<Issue> findAll(){
		return repository.findAll();
	}
	
	public Issue findById(Long id){
		Optional<Issue> obj = repository.findById(id);
		return obj.get();
	}
	
	public Issue create(Issue obj) {
		return repository.save(obj);
	}
	
	public Issue update(Long id, Issue obj) {
		Issue entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Issue entity, Issue obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setDescricao(obj.getDescricao());
		entity.setDone(obj.isDone());
		entity.setGroupId(obj.getGroupId());
	}
	
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
