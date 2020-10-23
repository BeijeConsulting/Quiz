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
	@Column
	private Integer test;
	@Column
	private Integer question;
	@Column
	private String answer;
	@Column
	private Boolean correct;
	@Column
	private int ind;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTest() {
		return test;
	}
	public void setTest(Integer test) {
		this.test = test;
	}
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
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
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
	
	
}
