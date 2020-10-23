package it.beije.quiz.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "results")
public class Result {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="date_time_begin")
	private LocalDateTime dateTimeBegin;
	
	@Column(name="date_time_end")
	private LocalDateTime dateTimeEnd;
	
	@Column(name="score")
	private int score;
	
	@Column(name="questions_number")
	private int questionsNumber;
	
	@JsonProperty("test_name")
	@Column(name="test_name")
	private String testName;
	
	public Result() {}
	public Result(Integer userId, LocalDateTime dateTimeBegin, LocalDateTime dateTimeEnd,
			int score, int questionsNumber, String testName) {
		this.userId=userId;
		this.dateTimeBegin = dateTimeBegin;
		this.dateTimeEnd = dateTimeEnd;
		this.score = score;
		this.questionsNumber = questionsNumber;
		this.testName = testName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateTimeBegin() {
		return dateTimeBegin;
	}

	public void setDateTimeBegin(LocalDateTime dateTimeBegin) {
		this.dateTimeBegin = dateTimeBegin;
	}

	public LocalDateTime getDateTimeEnd() {
		return dateTimeEnd;
	}

	public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getQuestionsNumber() {
		return questionsNumber;
	}

	public void setQuestionsNumber(int questionsNumber) {
		this.questionsNumber = questionsNumber;
	}
	
	public String toJson() {
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"id_esame\":\"").append(this.id).append("\",");
		sb.append("\"nome_esame\":\"").append(this.testName).append("\",");
		sb.append("\"id_esame\":\"").append(this.id).append("\",");
		sb.append("\"data_ora_inizio\":\"").append(this.dateTimeBegin.toString()).append("\",");
		sb.append("\"data_ora_fine\":\"").append(this.dateTimeEnd.toString()).append("\",");
		sb.append("\"score\":\"").append(this.score).append("\"");
		sb.append("}");
		return sb.toString();
	}
}
