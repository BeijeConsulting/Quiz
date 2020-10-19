package it.beije.quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "domande")
public class Domanda {
	
	public static final String ANSWER_TYPE_CHECKBOX = "checkbox";
	public static final String ANSWER_TYPE_RADIO = "radio";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDomanda;

	@Column(name = "id_da_xml")
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
	private String answerType;
	@Column
	private String risposte; //saved as LETTERARISPOSTA(unito)RISPOSTA/
	@Transient
	private String rispostaUtente = "";
	@Column
	private String rispostaEsatta;
	@Column
	private String spiegazione;

	public Domanda(){}

	public Domanda(Long id, String book, int chapter, int question, String testo,
				   String answerType, String risposte,
				   String rispostaEsatta, String spiegazione) {
		this.id = id;
		this.book = book;
		this.chapter = chapter;
		this.question = question;
		this.testo = testo;
		this.rispostaEsatta = rispostaEsatta;
		this.answerType = answerType;
		this.risposte = risposte;
		this.spiegazione = spiegazione;
	}
	
	public Long getId() {
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

	public String getRisposte() {
		return risposte;
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
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("book : ").append(book).append('\n');
		builder.append("chapter : ").append(chapter).append('\n');
		builder.append("question : ").append(question).append('\n');
		builder.append("testo : ").append(testo).append('\n');
		builder.append("rispostaEsatta : ").append(rispostaEsatta).append('\n');
		builder.append("rispostaUtente : ").append(rispostaUtente).append('\n');
		builder.append("answerType : ").append(answerType).append('\n');
		builder.append("RISPOSTE\n");
		builder.append(risposte);

		return builder.toString();
	}

	public Long getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(Long idDomanda) {
		this.idDomanda = idDomanda;
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
//		builder.append(risposte);
//		builder.append("}}");
//
//		return builder.toString();
//	}
}