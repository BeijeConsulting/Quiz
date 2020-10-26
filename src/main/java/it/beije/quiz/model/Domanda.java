package it.beije.quiz.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "domande")
public class Domanda {
	
	public static final String ANSWER_TYPE_CHECKBOX = "checkbox";
	public static final String ANSWER_TYPE_RADIO = "radio";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "book_title")
	private String book;

	@Column
	private Integer chapter;

	@Column
	private Integer question;

	@Column
	private String testo;

	@Column(name="answer_type")
	@JsonProperty("answer_type")
	private String answerType;

	@Column(name="book_id")
	@JsonProperty("book_id")
	private Integer bookId;

	@Transient
	private String rispostaUtente = "";

	@Column(name="risposta_esatta")
	@JsonProperty("risposta_esatta")
	private String rispostaEsatta;
	@Column
	private String spiegazione;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Domanda(){}

	public Domanda(Integer id, String book, int chapter, int question, String testo,
				   String answerType,
				   String rispostaEsatta, String spiegazione) {
		this.id = id;
		this.book = book;
		this.chapter = chapter;
		this.question = question;
		this.testo = testo;
		this.rispostaEsatta = rispostaEsatta;
		this.answerType = answerType;
		this.spiegazione = spiegazione;
	}

	public Domanda(String book, int chapter, int question, String testo,
				   String answerType,
				   String rispostaEsatta, String spiegazione) {
		this.book = book;
		this.chapter = chapter;
		this.question = question;
		this.testo = testo;
		this.rispostaEsatta = rispostaEsatta;
		this.answerType = answerType;
		this.spiegazione = spiegazione;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getChapter() {
		return chapter;
	}
	
	public String getTesto() {
		return testo;
	}
	
	public String getRispostaEsatta() {
		return rispostaEsatta;
	}

	public String getSpiegazione() {
		return spiegazione;
	}

	public String getBook() {
		return book;
	}

	public Integer getQuestion() {
		return question;
	}
	
	public String getRispostaUtente() {
		return rispostaUtente == null ? "" : rispostaUtente;
	}
	public void setRispostaUtente(String rispostaUtente) {
		if (rispostaUtente != null){
			this.rispostaUtente = rispostaUtente;
		} else {
			this.rispostaUtente = "";
		}
	}

	public String getAnswerType() {
		return answerType;
	}
}