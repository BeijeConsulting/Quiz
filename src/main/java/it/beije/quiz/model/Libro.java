package it.beije.quiz.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.beije.quiz.Utils;

public class Libro {
	




	public static final String LIB_PATH="C:\\Users\\Padawan09\\git\\Quiz\\domande\\";

	
	private String checked="";

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
	
	public ArrayList<Domanda> caricaQuestions() {
		System.out.println("entroooo");
		ArrayList<Domanda> listaD = new ArrayList<Domanda>();
		File folder = new File(LIB_PATH+nameDir);
		System.out.println(LIB_PATH+nameDir);
		
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
//			Pattern pat = Pattern.compile("^.*\\.[xml]$");
//			Matcher m = pat.matcher(listOfFiles[i].getName());
//			if (listOfFiles[i].isFile() && m.matches()) {
				listaD.addAll(Utils.readFileDomande(listOfFiles[i].getPath()));
//			}
		}
		
		
		
		return listaD;
	}
}

