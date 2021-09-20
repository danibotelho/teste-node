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
@Table(name = "groups")
public class Group{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "titulo")
		private String titulo;
		
		@OneToMany(targetEntity=User.class, fetch=FetchType.EAGER)
	    @JoinColumn(name="user_id")
	    private User user_id;
		
		public Group() {
			
		}
		

		public Group(String titulo, User user_id) {
			this.titulo = titulo;
			this.user_id = user_id;
		}


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public User getUser_id() {
			return user_id;
		}

		public void setUser_id(User user_id) {
			this.user_id = user_id;
		}
		
		
		
}