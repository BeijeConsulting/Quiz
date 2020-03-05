package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;


@Service
public class QuizService {

	public final String baseDirectory = "C:\\Users\\Padawan04\\git\\Quiz\\domande\\";
	
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
					domande.addAll(Utils.readFileDomande(ff.getAbsolutePath(), dir));
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

	public void ricaricaDomande() {
		caricaDomande();
	}
}
