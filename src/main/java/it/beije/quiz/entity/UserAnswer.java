package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_answer")
public class UserAnswer{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_answer_id")
	private Integer UserAnswerId;

	@Column(name="user")
	private Integer userId;
	
	@Column(name = "quiz")
	private Integer quizId;

	@Column(name = "question")
	private Integer questionId;

	@Column(name="answer")
	private String answer;

	@Column(name="correct")
	private Boolean correct;

	public Integer getUserAnswerId() {
		return UserAnswerId;
	}
	public void setUserAnswerId(Integer UserAnswerId) {
		this.UserAnswerId = UserAnswerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
}