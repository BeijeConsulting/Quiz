package it.beije.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name = "id_utente")
	private Long idUtente;
	@Column
	private String domande;
	@Column
	private String risposteUtente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	public String getDomande() {
		return domande;
	}
	public void setDomande(String domande) {
		this.domande = domande;
	}
	public String getRisposteUtente() {
		return risposteUtente;
	}
	public void setRisposteUtente(String risposteUtente) {
		this.risposteUtente = risposteUtente;
	}
}
