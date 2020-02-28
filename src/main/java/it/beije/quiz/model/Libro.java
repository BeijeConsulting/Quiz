package it.beije.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private String id_book;
	private String title;
	private String dir;
	private List<Domanda> domande;
	private boolean valore=false;
	
	public boolean setValore(boolean valore) {return valore;}
	public List<Domanda> getDomande() {
		return domande;
	}
	public void setDomande(List<Domanda> domande) {
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
	@Override
	public String toString() {
		return "Libro [id_book=" + id_book + ", title=" + title + ", dir=" + dir + ", domande=" + domande + ", valore="
				+ valore + "]";
	}
	
	
}
