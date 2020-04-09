package com.cubic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class User {
		
		@Id
		@GeneratedValue
		private int id;
		@NotBlank
		@Size(min=2,max=100,message="Your name should be min 2 and max 100 characters")
		private String username;
		@Email
		private String email;
		
		public User() {}
		
		public User(String username, String email) {
			super();
			this.username = username;
			this.email = email;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
}
