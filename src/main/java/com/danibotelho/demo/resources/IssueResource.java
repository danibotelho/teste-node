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

import com.danibotelho.demo.entities.Issue;
import com.danibotelho.demo.services.IssueService;

@RestController
@RequestMapping(value = "/issues")
public class IssueResource {

	@Autowired
	private IssueService service;
	
	@GetMapping
	public ResponseEntity<List<Issue>> findAll(){
		List<Issue> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Issue> findById(@PathVariable Long id){
		Issue obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Issue> insert(@RequestBody Issue obj) {
		obj = service.create(obj);
		 return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Issue> update(@PathVariable Long id, @RequestBody Issue obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
