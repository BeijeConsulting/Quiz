package it.beije.quiz.model;

public class Libro {
	
	private String idBook;
	private String dir;
	private String title;
	private Domanda domanda;
	
	

	public String getDir() {
		return dir;
	}

	public String getTitle() {
		return title;
	}

	public Domanda getDomanda() {
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

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	@Override
	public String toString() {
		return "Libro [idBook=" + idBook + ", dir=" + dir + ", title=" + title + "]";
	}
	
	
	
	

}
