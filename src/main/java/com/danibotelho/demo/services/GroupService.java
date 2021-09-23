package com.danibotelho.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danibotelho.demo.entities.Group;
import com.danibotelho.demo.repositories.GroupRepository;


@Service
public class GroupService {

	@Autowired
	private GroupRepository  repository;
	
		
	public List<Group> findAll(){
		return repository.findAll();
	}
	
	public Group  findById(Long id){
		Optional<Group> obj = repository.findById(id);
		return obj.get();
	}
	
	public Group create(Group obj) {
		return repository.save(obj);
	}
	
	public Group update(Long id, Group obj) {
		Group entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Group entity, Group obj) {
		entity.setTitulo(obj.getTitulo());
		
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	
}
