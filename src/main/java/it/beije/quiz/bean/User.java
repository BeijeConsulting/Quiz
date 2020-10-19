package it.beije.quiz.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder().append("User [");
		
		sb.append("name: ");
		if(name == null) {
			sb.append(name);
		} else {
			sb.append("\"").append(name).append("\"");
		}
		
		sb.append(" - ").append("surname: ");
		if(surname == null) {
			sb.append(surname);
		} else {
			sb.append("\"").append(surname).append("\"");
		}
		
		sb.append(" - ").append("email: ");
		if(email == null) {
			sb.append(email);
		} else {
			sb.append("\"").append(email).append("\"");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
