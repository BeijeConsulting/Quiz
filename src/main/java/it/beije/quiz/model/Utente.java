package it.beije.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
		
	@Column(name="email")
	private String email;

	@Column
	private String password;
	
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String nickname) {
		this(nome, cognome, nickname, "");
	}
	
	public Utente(String nome, String cognome, String nickname, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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

		StringBuilder builder = new StringBuilder("[");
		builder.append("Nome : ").append(this.nome)
			.append(" - Cognome : ").append(this.cognome)
			.append(" - Email : ").append(this.email).append("]");

		
		return builder.toString();
	}
	
}