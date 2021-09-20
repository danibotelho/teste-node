package com.danibotelho.toDo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danibotelho.toDo.exceptions.ResourceNotFoundException;
import com.danibotelho.toDo.models.Issue;
import com.danibotelho.toDo.repositories.IssueRepository;

@RestController
@RequestMapping("issues")
public class IssueController {

	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/issues")
	public List<Issue> getAllIssue() {
		return issueRepository.findAll();
	}
	
	@GetMapping("/issues/{id}")
	public ResponseEntity<Issue> getIssueById(@PathVariable(value = "id") Long issueId)
		throws ResourceNotFoundException {
	Issue issue = issueRepository.findById(issueId)
			.orElseThrow(()-> new ResourceNotFoundException("Issue não encontrada para o ID: " + issueId));
	return ResponseEntity.ok().body(issue);
	}
	
	@PostMapping
	public Issue createIssue(@Validated @RequestBody Issue issue) {
		return issueRepository.save(issue);
	}
	
	@PostMapping("/issues/{id}")
	public ResponseEntity<Issue> updateIssue(@PathVariable(value = "id") Long issueId,
			@Validated @RequestBody Issue employeeDetails) throws ResourceNotFoundException {
		Issue issue = issueRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue não encontrada para o ID: "+ issueId));

		issue.setTitulo(employeeDetails.getTitulo());
		issue.setDescricao(employeeDetails.getDescricao());
		issue.setDone(employeeDetails.getDone());
		final Issue updatedIssue = issueRepository.save(issue);
		return ResponseEntity.ok(updatedIssue);
	}
	
	@DeleteMapping("/issue/{id}")
	public Map<String, Boolean> deleteIssue(@PathVariable(value = "id") Long issueId)
			throws ResourceNotFoundException {
		Issue issue = issueRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue não encontrada para o ID: "+ issueId));

		issueRepository.delete(issue);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
	
	
}
