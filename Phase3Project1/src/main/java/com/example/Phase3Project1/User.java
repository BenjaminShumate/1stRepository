package com.example.Phase3Project1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity @Table
public class User {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String username;
		private String password;
		
		//The constructors may be irrelevant
		public User() {
			super();
		}

		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getUserId() {
			return id;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
		}
		

}
