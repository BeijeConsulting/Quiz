package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;


@Service
public class QuizService {
	
	private static final String baseDirectory = "C:\\Users\\Padawan07\\git\\Quiz\\domande\\";
	private static List<Libro> listaLibriInXML = null;

	
	public String getBaseDirectory() {
		return baseDirectory;
	}

	public  List <Libro> getListaLibri(){
		if(listaLibriInXML==null)
			listaLibriInXML=Utils.caricaLibriDaIndexXML(baseDirectory+"index.xml");
		
		return listaLibriInXML;
	}


	public QuizService() {
		System.out.println("Creo istanza di QuizService");
	}

	private List<Domanda> domande = null;

	private void caricaDomande() {
		domande = new ArrayList<Domanda>();
		File f = new File(baseDirectory);
		String dir = "";
		for(File file : f.listFiles()) {
			if(file.isDirectory()) {
				dir = file.getName();
				for(File ff : file.listFiles()) {
					domande.addAll(Utils.readFileDomande(ff.getPath()));
				}
			} 
		}
	}

	public List<Domanda> getDomande() {
		if (domande == null) {
			caricaDomande();
		}

		return domande;
	}
	
	
		
		
	
	
}