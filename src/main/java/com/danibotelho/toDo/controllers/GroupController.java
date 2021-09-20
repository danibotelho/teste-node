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
import com.danibotelho.toDo.models.Group;
import com.danibotelho.toDo.repositories.GroupRepository;

@RestController
@RequestMapping("/groups")
public class GroupController {
	
	@Autowired
		private GroupRepository groupRepository;

		@GetMapping("/groups")
		public List<Group> getAllGroups() {
			return groupRepository.findAll();
		}

		@GetMapping("/groups/{id}")
		public ResponseEntity<Group> getGroupById(@PathVariable(value = "id") Long groupId)
				throws ResourceNotFoundException {
			Group group = groupRepository.findById(groupId)
					.orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado para o id: " + groupId));
			return ResponseEntity.ok().body(group);
		}

		@PostMapping("/groups")
		public Group createGroup(@Validated @RequestBody Group group) {
			return groupRepository.save(group);
		}

		@PostMapping("/groups/{id}")
		public ResponseEntity<Group> updateGroup(@PathVariable(value = "id") Long groupId,
				@Validated @RequestBody Group groupDetails) throws ResourceNotFoundException {
			Group group = groupRepository.findById(groupId)
					.orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado para o id: " + groupId));

			group.setTitulo(groupDetails.getTitulo());
			group.setUser_id (groupDetails.getUser_id());
			final Group updatedGroup = groupRepository.save(group);
			return ResponseEntity.ok(updatedGroup);
		}

		@DeleteMapping("/groups/{id}")
		public Map<String, Boolean> deleteGroup(@PathVariable(value = "id") Long groupId)
				throws ResourceNotFoundException {
			Group group = groupRepository.findById(groupId)
					.orElseThrow(() -> new ResourceNotFoundException("Grupo não encontrado para o id: " + groupId));

			groupRepository.delete(group);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deletado", Boolean.TRUE);
			return response;
		}

}
