package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;
	
	
	public User() {}

	public User(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		StringBuilder builder = new StringBuilder("utente [");
		builder.append("nickname : ").append(this.nickname)
			.append(" - email : ").append(this.email).append("]");
		
		return builder.toString();
	}
	
}
