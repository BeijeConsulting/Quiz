package it.beije.quiz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QNA {

	@JsonProperty("question_id")
	private Integer questionId;
	@JsonProperty("answer_id")
	private Integer answerId;
	@JsonProperty("raw_text")
	private String rawText; //JSON???
	@JsonProperty("answer_type")
	private String answerType;
	private String options;
	@JsonProperty("user_choice")
	private String userChoice;
	private String corrects;
	
	
	public QNA(Question q, Answer a, String userChoice) {
		this.questionId=q.getId();
		this.answerId=a.getId();
		this.rawText=q.getText();
		this.answerType=q.getAnswerType();
		this.options=a.getOptions();
		this.corrects = a.getCorrects();
		this.userChoice= userChoice;
		
	}
	
	public QNA() {}
	
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
	public String getRawText() {
		return rawText;
	}
	public void setRawText(String rawText) {
		this.rawText = rawText;
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
	public String getCorrects() {
		return corrects;
	}
	public void setCorrects(String corrects) {
		this.corrects = corrects;
	}

	@Override
	public String toString() {
		return "QNA [questionId=" + questionId + ", answerId=" + answerId + ", rawText=" + rawText + ", answerType="
				+ answerType + ", options=" + options + ", userChoice=" + userChoice + "]";
	}
}
