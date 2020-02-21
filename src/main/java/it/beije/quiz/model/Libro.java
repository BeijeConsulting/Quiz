package it.beije.quiz.model;

import java.util.List;

public class Libro {
	
	private String idBook;
	private String dir;
	private String title;
	private int nCapitoli;
	private List<Domanda> domanda;
	
	

	public String getDir() {
		return dir;
	}

	public String getTitle() {
		return title;
	}
	
	public int getNcapitoli() {
		return nCapitoli;
	}

	public List<Domanda> getDomanda() {
		return domanda;
	}

	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setNcapitoli(int nCapitoli) {
		this.nCapitoli=nCapitoli;
	}

	public void setDomanda(List<Domanda> domanda) {
		this.domanda = domanda;
	}

	@Override
	public String toString() {
		return "Libro [idBook=" + idBook + ", dir=" + dir + ", title=" + title + "]";
	}
	
	
	
	

}
