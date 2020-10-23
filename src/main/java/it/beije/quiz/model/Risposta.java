package it.beije.quiz.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Semplice entity Risposta
 */
@Entity
@Table(name = "risposta")
public class Risposta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="id_domanda")
	private Long idDomanda;
	@Column
	private String lettera;
	@Column
	private String risposta;
	@Column
	private boolean corretto;
	@Column
	private String book;
	@Column
	private Integer chapter;
	public Risposta() {}
	public Risposta(Long idDomanda, String lettera, String risposta, boolean corretto, String book, Integer chapter) {
		this.idDomanda = idDomanda;
		this.lettera = lettera;
		this.risposta = risposta;
		this.corretto = corretto;
		this.book = book;
		this.chapter = chapter;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDomanda() {
		return idDomanda;
	}
	public void setIdDomanda(Long idDomanda) {
		this.idDomanda = idDomanda;
	}
	public String getLettera() {
		return lettera;
	}
	public void setLettera(String lettera) {
		this.lettera = lettera;
	}
	public String getRisposta() {
		return risposta;
	}
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("idDomanda : ").append(idDomanda).append('\n');
		builder.append("lettera : ").append(lettera).append('\n');
		builder.append("risposta : ").append(risposta).append('\n');
		builder.append("corretto : ").append(corretto).append('\n');
//		builder.append("answerType : ").append(answerType).append('\n');
//		builder.append("RISPOSTE\n");
//		for (Risposta r : risposte) {
//			builder.append("  ").append(r.getValue()).append(" - ").append(r.getText()).append('\n');
//		}
//		builder.append("----------------------------\n");
		return builder.toString();
	}
}