package com.danibotelho.toDo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "done")
	private Boolean done;
	
	@OneToMany(targetEntity=Group.class, fetch=FetchType.EAGER)
    @JoinColumn(name="group_id")
	private Group group_id;
	
	@OneToMany(targetEntity=User.class, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
	private User user_id;

	public Issue(String titulo, String descricao, Boolean done, Group group_id, User user_id) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.done = done;
		this.group_id = group_id;
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Group getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Group group_id) {
		this.group_id = group_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	
	
	
	
}
