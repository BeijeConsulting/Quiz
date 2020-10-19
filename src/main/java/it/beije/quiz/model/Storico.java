package it.beije.quiz.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storico")
public class Storico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="data")
	private LocalDate data;
	
	@Column(name="durata")
	private String durata;
	
	@Column(name="esito")
	private boolean esito;
	
	@Column(name="score")
	private double score;

	@Column(name="idutente")
	private Integer idutente;
	
	@Column(name="punteggio")
	private String punteggio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public boolean isEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		this.esito = esito;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Integer getIdutente() {
		return idutente;
	}

	public void setIdutente(Integer idutente) {
		this.idutente = idutente;
	}

	public String getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(String punteggio) {
		this.punteggio = punteggio;
	}

}
