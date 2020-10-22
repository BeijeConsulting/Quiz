package it.beije.quiz.entity;

public class QNA {

	private Integer questionId;
	private Integer answerId;
	private String test;
	private String answerType;
	private String options;
	private String userChoice;
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getUserChoice() {
		return userChoice;
	}
	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}
	@Override
	public String toString() {
		return "QNA [questionId=" + questionId + ", answerId=" + answerId + ", test=" + test + ", answerType="
				+ answerType + ", options=" + options + ", userChoice=" + userChoice + "]";
	}
}
