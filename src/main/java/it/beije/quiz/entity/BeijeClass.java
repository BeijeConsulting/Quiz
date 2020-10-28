package it.beije.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class BeijeClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "class_id")
	private Integer beijeClassId;
	
	@Column(name="name")
	private String name;
	
	public BeijeClass() {}

	public Integer getBeijeClassId() {
		return beijeClassId;
	}
	public void setBeijeClassId(Integer beijeClassId) {
		this.beijeClassId = beijeClassId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}