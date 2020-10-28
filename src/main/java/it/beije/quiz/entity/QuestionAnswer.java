package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_answer")
public class QuestionAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_answer_id")
	private Integer questionAnswerId;
	
	@Column(name = "question")
	private Integer questionId;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "text")
	private String text;
	
	
	public QuestionAnswer() {}
	
	public QuestionAnswer(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public Integer getQuestionAnswerId() {
		return questionAnswerId;
	}
	public void setQuestionAnswerId(Integer questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
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