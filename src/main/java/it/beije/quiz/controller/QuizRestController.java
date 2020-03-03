package it.beije.quiz.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.service.QuizService;

@RestController
public class QuizRestController {
	
	private final String MAIN_PATH = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	private List<Libro> LIBRI;
	
	@Autowired(required= false)
	private QuizService quizService;
	
	
	@RequestMapping(value = "/restbest", method = RequestMethod.POST,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda newDomanda(@RequestBody Domanda domanda) {
		boolean isNew=false;
		System.out.println("Inizio");
		try {
			LIBRI = Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for (Libro l : LIBRI) {
			if(l.getIdBook().equals(domanda.getBook())){
				Utils.caricaDomande(l, l.getIdBook() , domanda);
				isNew=false;
			}else 
				isNew=true;
		}
		
		if(isNew){
			System.out.println("Inizio new libro");
			Libro libro = new Libro();
			libro.setIdBook(domanda.getBook());
			libro.setNameDir(domanda.getBook());
			libro.setTitle(domanda.getBook());
			Utils.createLibro(libro);
			Utils.caricaDomande(libro, libro.getIdBook() , domanda);
		}
		
		return domanda;
	}
	
	@RequestMapping(value = "/restbestget", method = RequestMethod.GET,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> getDomanda() {
		List<Libro> libriCarichi= quizService.getLibriCarichi();
		return libriCarichi.get(0).getDomande();
	}
	
}
