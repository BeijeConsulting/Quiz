package it.beije.quiz.model;



public class Libro {
	
	private String idBook;
	private String dir;
	private String title;
	
	public Libro() {
	}
	
	

	public String getDir() {
		return dir;
	}

	public String getTitle() {
		return title;
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
	


	@Override
	public String toString() {
		return "Libro [idBook=" + idBook + ", dir=" + dir + ", title=" + title + "]";
	}
	
	
	
	

}
