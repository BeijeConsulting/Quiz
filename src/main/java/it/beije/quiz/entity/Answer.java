package it.beije.quiz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private Integer id;

	@Column(name = "test")
	private Integer idTest;

	@Column(name = "questions")
	private Integer idQuestions;

	@Column
	private String answer;

	@Column
	private Boolean correct;

	@Column(name = "ind")
	private int answerIndex;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdTest() {
		return idTest;
	}
	public void setIdTest(Integer test) {
		this.idTest = test;
	}
	public Integer getIdQuestions() {
		return idQuestions;
	}
	public void setIdQuestions(Integer question) {
		this.idQuestions = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Boolean getCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	public int getAnswerIndex() {
		return answerIndex;
	}
	public void setAnswerIndex(int ind) {
		this.answerIndex = ind;
	}
}
