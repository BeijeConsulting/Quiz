package it.beije.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private String id_book;
	private String title;
	private String dir;
	private List<List<Domanda>> domande;
	
	

	public List<List<Domanda>> getDomande() {
		return domande;
	}
	public void setDomande(List<List<Domanda>> domande) {
		this.domande = domande;
	}
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
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}

}
