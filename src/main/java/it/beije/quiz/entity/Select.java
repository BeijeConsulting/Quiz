package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Relazione tra quiz e domande.
 * Rappresenta la selezione di domande scelte per un dato quiz. 
 */

@Entity
@Table(name="select")
public class Select {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "select_id")
	private Integer selectId;
	
	@Column(name = "quiz")
	private Integer quizId;
	
	@Column(name = "question")
	private Integer questionId;
	
	public Select() {}

	public Integer getSelectId() {
		return selectId;
	}
	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
}