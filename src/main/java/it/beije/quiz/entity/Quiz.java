package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "quiz_id")
	private Integer quizId;

	@Column(name="name")
	private String name;

	@Column(name="duration")
	private String duration;

	@Column(name="class")
	private Integer beijeClassId;
	
	public Quiz() {}

	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getBeijeClassId() {
		return beijeClassId;
	}
	public void setBeijeClassId(Integer beijeClassId) {
		this.beijeClassId = beijeClassId;
	}
}
