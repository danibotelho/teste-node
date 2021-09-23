package com.danibotelho.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danibotelho.demo.entities.Group;
import com.danibotelho.demo.services.GroupService;

@RestController
@RequestMapping(value = "/groups")
public class GroupResource {

	@Autowired
	private GroupService service;
	
	@GetMapping
	public ResponseEntity<List<Group>> findAll(){
		List<Group> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Group> findById(@PathVariable Long id){
		Group obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Group> insert(@RequestBody Group obj) {
		obj = service.create(obj);
		 return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Group> update(@PathVariable Long id, @RequestBody Group obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
