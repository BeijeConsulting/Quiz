package it.beije.quiz.model;

import java.util.List;

public class Libro {
	
	public static final String PATH_INDEX_BOOKS = null;
	
	 private String idBook;
	 private String title;
	 private String nameDir;
	 private List<Domanda> questions = null;
	 
	
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
	
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
}	
