package it.beije.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Libro {

//	public static final String LIB_PATH = "C:\\Users\\Gabriele\\git\\Quiz\\domande\\";
	@JsonIgnore
	private String checked = "";

	private String idBook;
	private String title;
	private String nameDir;

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

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}
