package it.beije.quiz.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	private List<Libro> LIBRI = new ArrayList<Libro>();
	
	@Autowired
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
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> getAllDomande() {
		
		List<Libro> libri = new ArrayList<Libro>();
		
		try 
		{
			libri = Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
			
			for (Libro l : libri) {
				l.setDomande(quizService.getLibriCarichi(l));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
				
		return libri.get(0).getDomande();
	}
	
	@RequestMapping(value = "/getone/{id}", method = RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Domanda getDomanda(@PathVariable String id) {
		Domanda dOut=new Domanda();	
		try 
			{
				List<Libro> libri= Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
				
				for (Libro l : libri) {
					l.setDomande(quizService.getLibriCarichi(l));
					for (Domanda d : l.getDomande()) {
						System.out.println(d.getId());
						if (d.getId().trim().equals(id.trim()))dOut= d;
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return dOut;	
	}
	
	@RequestMapping(value = "/getchapter/{id}", method = RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<Domanda> getDomandaFromCapitolo(@PathVariable String id) {
		List <Domanda> dOut=new ArrayList<Domanda>();	
		String chapter = id.split("-")[1];
		try 
			{
				List<Libro> libri= Utils.caricaLibri(new File(MAIN_PATH + "index.xml"));
				
				for (Libro l : libri) {
					l.setDomande(quizService.getLibriCarichi(l));
					for (Domanda d : l.getDomande()) {
						System.out.println(d.getId());
						if(chapter.equals(d.getChapter()))dOut.add(d);
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return dOut;
				
			
		}
	
}
