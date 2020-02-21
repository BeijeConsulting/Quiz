package it.beije.quiz.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import it.beije.quiz.Utils;

public class Libro {
	
<<<<<<< HEAD
//	public static final String PATH_INDEX_BOOKS = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\index.xml";
	private static final String LIB_PATH="C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
=======
	private static final String LIB_PATH="C:\\Users\\Padawan09\\git\\Quiz\\domande\\";
>>>>>>> refs/remotes/origin/BranchDelBosco09
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

	
	public List<Domanda> caricaQuestions() {
		System.out.println("entroooo");
		List<Domanda> listaD = new ArrayList<Domanda>();
		File folder = new File(LIB_PATH+nameDir);
		File[] listOfFiles = folder.listFiles();
		

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile() && Pattern.matches("^.*\\.[xml]$", listOfFiles[i].getName())) {

				listaD.addAll(Utils.readFileDomande(listOfFiles[i].getAbsolutePath()));
			}
		}
		
//		for(Domanda d : listaD) {
//			System.out.println(d.toString());
//		}
		
		return listaD;
	}
}

