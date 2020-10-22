package it.beije.quiz.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="date_time_begin")
	private LocalDateTime dateTimeBegin;
	
	@Column(name="date_time_end")
	private LocalDateTime dateTimeEnd;
	
	@Column(name="score")
	private int score;
	
	@Column(name="questions_number")
	private int questions_number;
	
	@Column(name="test_name")
	private String test_name;
	
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

	public int getQuestions_number() {
		return questions_number;
	}

	public void setQuestions_number(int questions_number) {
		this.questions_number = questions_number;
	}
	
}