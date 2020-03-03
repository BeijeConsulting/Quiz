package it.beije.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private String idBook;
	private String title;
	private String nameDir;
	private List<Domanda> domande;
	private boolean valore=false;
	
	public boolean setValore(boolean valore) {return valore;}
	public List<Domanda> getDomande() {
		return domande;
	}
	public void setDomande(List<Domanda> domande) {
		this.domande = domande;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String id_book) {
		this.idBook = id_book;
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
	public void setNameDir(String dir) {
		this.nameDir = dir;
	}
	@Override
	public String toString() {
		return "Libro [id_book=" + idBook + ", title=" + title + ", dir=" + nameDir + ", domande=" + domande + ", valore="
				+ valore + "]";
	}
	
	
}
