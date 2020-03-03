package it.beije.quiz.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private String idBook;
	private String title;
<<<<<<< HEAD
	private String dir;
	private List<Domanda> domande;
=======
	private String nameDir;
	private List<Domanda> domande;
	private boolean valore=false;
>>>>>>> refs/remotes/origin/Master_GruppoFox
	
<<<<<<< HEAD
	

=======
	public boolean setValore(boolean valore) {return valore;}
>>>>>>> refs/remotes/origin/Master_GruppoFox
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
