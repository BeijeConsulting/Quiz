package it.beije.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import java.util.List;

/*
 * Semplice entity Domanda
 */

@Entity
@Table(name = "quiz")
public class Domanda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column
	private String book;
	@Column
	private Integer chapter;
	@Column
	private Integer question;
	@Column
	private String testo;
	@Column
	private String type;
	@Column
	private String spiegazione;
	
	public Domanda() {}
	
	public Domanda(String book, int chapter, int question, String testo, String type,
			String spiegazione) {
		this.book = book;
		this.chapter = chapter;
		this.question = question;
		this.testo = testo;
		this.type = type;
		this.spiegazione = spiegazione;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpiegazione() {
		return spiegazione;
	}
	public void setSpiegazione(String spiegazione) {
		this.spiegazione = spiegazione;
	}





	//	public static final String ANSWER_TYPE_CHECKBOX = "checkbox";
//	public static final String ANSWER_TYPE_RADIO = "radio";
//
//	private int id;
//	private String book;
//	private int chapter;
//	private int question;
//	private String testo;
//	private String answerType;
//	private List<Risposta> risposte;
//	private String rispostaUtente = "";
//	private String rispostaEsatta;
//	private String spiegazione;
//	
//	public Domanda(int id, String book, int chapter, int question, String testo,
//			String answerType, List<Risposta> risposte,
//			String rispostaEsatta, String spiegazione) {
//		this.id = id;
//		this.book = book;
//		this.chapter = chapter;
//		this.question = question;
//		this.testo = testo;
//		this.rispostaEsatta = rispostaEsatta;
//		this.answerType = answerType;
//		this.risposte = risposte;
//		this.spiegazione = spiegazione;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	
//	public int getChapter() {
//		return chapter;
//	}
//	
//	public String getTesto() {
//		return testo;
//	}
//	
//	public String getRispostaEsatta() {
//		return rispostaEsatta;
//	}
//
//	public String getSpiegazione() {
//		return spiegazione;
//	}
//
//	public List<Risposta> getRisposte() {
//		return risposte;
//	}
//
//	public String getBook() {
//		return book;
//	}
//
//	public int getQuestion() {
//		return question;
//	}
//	
//	public String getRispostaUtente() {
//		return rispostaUtente;
//	}
//	public void setRispostaUtente(String rispostaUtente) {
//		this.rispostaUtente = rispostaUtente;
//	}
//	
//	public String getAnswerType() {
//		return answerType;
//	}
//	
//	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("book : ").append(book).append('\n');
		builder.append("chapter : ").append(chapter).append('\n');
		builder.append("question : ").append(question).append('\n');
		builder.append("testo : ").append(testo).append('\n');
		builder.append("type : ").append(type).append('\n');
		builder.append("spiegazione : ").append(spiegazione).append('\n');
//		builder.append("answerType : ").append(answerType).append('\n');
//		builder.append("RISPOSTE\n");
//		for (Risposta r : risposte) {
//			builder.append("  ").append(r.getValue()).append(" - ").append(r.getText()).append('\n');
//		}
//		builder.append("----------------------------\n");
		
		return builder.toString();
	}
//
//	public String toJson() {
//		StringBuilder builder = new StringBuilder("{");
//		builder.append("\"id\":").append(id).append(';');
//		builder.append("\"book\":\"").append(book).append("\";");
//		builder.append("\"chapter\":").append(chapter).append(';');
//		builder.append("\"question\":").append(question).append(';');
//		builder.append("\"testo\":\"").append(testo).append("\";");
//		builder.append("\"rispostaEsatta\":\"").append(rispostaEsatta).append("\";");
//		builder.append("\"rispostaUtente\":\"").append(rispostaUtente).append("\";");
//		builder.append("\"answerType\":\"").append(answerType).append("\";");
//		builder.append("\"risposte\":{");
//		for (Risposta r:risposte) {
//			builder.append("\"value\":\"").append(r.getValue()).append("\";");
//			builder.append("\"text\":\"").append(r.getText()).append("\";");
//		}
//		builder.append("}}");
//		
//		return builder.toString();
//	}
}
