package it.beije.quiz.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

@Service
public class QuizService {
	private final String MAIN_PATH = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	
	private List<Domanda> domande;

	private List<Libro> libriCarichi;
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
    
    public List<Libro> getLibriCarichi(){
		System.out.println("inizio passaggio");
		try {
			System.out.println("inizio caricamento");
			libriCarichi = Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
			
			for (Libro l : libriCarichi) {
				File folder = new File(MAIN_PATH + l.getNameDir());
				System.out.println("caricamento");

				for (File fileEntry : folder.listFiles()) {
					
					domande.addAll(Utils.readFileDomande(folder + "\\" + fileEntry.getName()));
					System.out.println("caricoooo");
				}
				
				l.setDomande(domande);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return libriCarichi;
    }
    
    
}
