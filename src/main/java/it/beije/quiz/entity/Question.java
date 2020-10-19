package it.beije.quiz.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import it.beije.quiz.model.Risposta;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Integer id;
	@Column
	private Integer chapter;
	@Column
	private String text;
	@Column
	private String answer;
	@Column(name = "possible_answers")
	private String possibleAnswers;
	@Column(name = "answer_type")
	private String answerType;
	@Column
	private String explanation;
	
	public Question() {}
	
	public Question(int id, int chapter_id, String text, String answerType, List<Risposta> answers,
			String answer, String expl) {
		this.id = id;
		this.chapter = chapter_id;
		this.text = text;
		this.answerType = answerType;
		this.answer = answer;
		StringBuilder answersBuilder = new StringBuilder();
		for(Risposta r : answers) {
			answersBuilder.append(r).append(" ||| ");
		}
		this.possibleAnswers = answersBuilder.toString();
		this.explanation = expl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChapter() {
		return chapter;
	}

	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPossibleAnswers() {
		return possibleAnswers;
	}

	public void setPossibleAnswers(String possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	
}
