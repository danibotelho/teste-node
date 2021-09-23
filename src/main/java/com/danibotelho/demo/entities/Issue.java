package com.danibotelho.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issues")
public class Issue implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String descricao;
	private boolean done;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private  Group groupId;

	
	public Issue() {}
	
	public Issue(Long id, String titulo, String descricao, boolean done, Group groupId) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.done = done;
		this.groupId = groupId;
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

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Group getGroupId() {
		return groupId;
	}

	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}
	
	
	
	/*
	@ManyToOne
	@JoinColumn(name = "user_id")
	private  User userId;
	 */

	
	
	
	
	
}
