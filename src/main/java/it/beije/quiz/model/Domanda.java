package it.beije.quiz.model;

import java.util.List;

public class Domanda {
	
	public static final String ANSWER_TYPE_CHECKBOX = "checkbox";
	public static final String ANSWER_TYPE_RADIO = "radio";

	private int id;
	private String book;
	private int chapter;
	private int question;
	private String testo;
	private String answerType;
	private List<Risposta> risposte;
	private String rispostaUtente = "";
	private String rispostaEsatta;
	private String spiegazione;
	
	public Domanda(int id, String book, int chapter, int question, String testo,
			String answerType, List<Risposta> risposte,
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
	
	public int getId() {
		return id;
	}
	
	public int getChapter() {
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

	public List<Risposta> getRisposte() {
		return risposte;
	}

	public String getBook() {
		return book;
	}

	public int getQuestion() {
		return question;
	}
	
	public String getRispostaUtente() {
		return rispostaUtente;
	}
	public void setRispostaUtente(String rispostaUtente) {
		this.rispostaUtente = rispostaUtente;
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
		for (Risposta r : risposte) {
			builder.append("  ").append(r.getValue()).append(" - ").append(r.getText()).append('\n');
		}
		builder.append("----------------------------\n");
		
		return builder.toString();
	}

	public String toJson() {
		StringBuilder builder = new StringBuilder("{");
		builder.append("\"id\":").append(id).append(';');
		builder.append("\"book\":\"").append(book).append("\";");
		builder.append("\"chapter\":").append(chapter).append(';');
		builder.append("\"question\":").append(question).append(';');
		builder.append("\"testo\":\"").append(testo).append("\";");
		builder.append("\"rispostaEsatta\":\"").append(rispostaEsatta).append("\";");
		builder.append("\"rispostaUtente\":\"").append(rispostaUtente).append("\";");
		builder.append("\"answerType\":\"").append(answerType).append("\";");
		builder.append("\"risposte\":{");
		for (Risposta r:risposte) {
			builder.append("\"value\":\"").append(r.getValue()).append("\";");
			builder.append("\"text\":\"").append(r.getText()).append("\";");
		}
		builder.append("}}");
		
		return builder.toString();
	}
}