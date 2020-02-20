package it.beije.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	String dir;
	String title;
	String id_book;
	List<Domanda> lista = new ArrayList<Domanda>();
	
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId_book() {
		return id_book;
	}
	public void setId_book(String id_book) {
		this.id_book = id_book;
	}
	public List<Domanda> getLista() {
		return lista;
	}
	public void setLista(List<Domanda> lista) {
		this.lista = lista;
	}
	
}
