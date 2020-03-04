package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

@Service
public class QuizService {
	private final String MAIN_PATH = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	
	@Autowired
	private Utils utils;

	private List<Libro> libriCarichi= new ArrayList<>();
	//	
	//    public QuizService(){
	//		try {
	//			System.out.println("inizio caricamento");
	//			libriCarichi = Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
	//			
	//			for (Libro l : libriCarichi) {
	//				File folder = new File(MAIN_PATH + l.getNameDir());
	//				System.out.println("caricamento");
	//
	//				for (final File fileEntry : folder.listFiles()) {
	//					l.getDomande().addAll(Utils.readFileDomande(folder + "\\" + fileEntry.getName()));
	//				}
	//			}
	//		} catch (Exception e) {
	//			// TODO: handle exception
	//			e.printStackTrace();
	//		}
	//    }

	public List<Domanda> getLibriCarichi(Libro l){
		System.out.println("inizio passaggio");
		List<Domanda> domande= new ArrayList<>();
		try {		

			File folder = new File(MAIN_PATH + l.getNameDir());

			for (final File fileEntry : folder.listFiles()) {
				System.out.println("caricoooo");
				domande.addAll(utils.readFileDomande(folder + "\\" + fileEntry.getName()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return domande;
	}


}
