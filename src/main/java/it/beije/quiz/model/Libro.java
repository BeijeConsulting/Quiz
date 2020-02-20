package it.beije.quiz.model;

import java.util.List;

public class Libro {
	
	 private String id_book;
	 private String title;
	 private String nameDir;
	 private List<Domanda> questions = null;
	 
	public String getId_book() {
		return id_book;
	}
	
	public void setId_book(String id_book) {
		this.id_book = id_book;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNameDir() {
		return nameDir;
	}
	
	public void setNameDir(String nameDir) {
		this.nameDir = nameDir;
	}
	
	public List<Domanda> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Domanda> questions) {
		this.questions = questions;
	}
	
	 
	 
}
