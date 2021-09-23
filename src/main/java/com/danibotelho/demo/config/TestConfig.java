package com.danibotelho.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.danibotelho.demo.entities.Group;
import com.danibotelho.demo.entities.Issue;
import com.danibotelho.demo.entities.User;
import com.danibotelho.demo.repositories.GroupRepository;
import com.danibotelho.demo.repositories.IssueRepository;
import com.danibotelho.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		
		Group o1 = new Group(null,"Titulo1", u1);
		Group o2 = new Group(null,"Titulo2", u2);
		Group o3 = new Group(null,"Titulo3", u1);
		
		Issue z1 = new Issue(null,"Titulo_issue1","Descricao1", true, o1);
		Issue z2 = new Issue(null,"Titulo_issue2","Descricao2", false,o2);
		Issue z3 = new Issue(null,"Titulo_issue3","Descricao3", true, o2);
		Issue z4 = new Issue(null,"Titulo_issue4","Descricao4", false, o1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		groupRepository.saveAll(Arrays.asList(o1,o2,o3));
		issueRepository.saveAll(Arrays.asList(z1,z2,z3,z4));
	}
	
	
}

