package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_answer_id")
	private Integer id;
	@Column
	private Integer question;
	@Column
	private String value;
	@Column
	private String text;
	
	public QuestionAnswer() {}
	
	public QuestionAnswer(String value, String text) {
		this.value = value;
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
