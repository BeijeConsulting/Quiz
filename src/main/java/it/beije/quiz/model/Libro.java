package it.beije.quiz.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import it.beije.quiz.Utils;

public class Libro {
	
//	public static final String PATH_INDEX_BOOKS = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\index.xml";
	private static final String LIB_PATH="C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	private String idBook;
	private String title;
	private String nameDir;
	private List<Domanda> questions = null;
	 
	
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
	
	public List<Domanda> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Domanda> questions) {
		this.questions = questions;
	}
	
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	
	public List<Domanda> caricaQuestions() {
		System.out.println("entroooo");
		List<Domanda> listaD = new ArrayList<Domanda>();
		File folder = new File(LIB_PATH+nameDir);
		File[] listOfFiles = folder.listFiles();
		

		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println("entroooo22222");
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().matches("^.*\\.[xml]$")) {
				System.out.println("entroooo3333");
				System.out.println(listOfFiles[i].getAbsolutePath());
				listaD.addAll(Utils.readFileDomande(listOfFiles[i].getAbsolutePath()));
			}
		}
		
//		for(Domanda d : listaD) {
//			System.out.println(d.toString());
//		}
		
		return listaD;
	}
}

