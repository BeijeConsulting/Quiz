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

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.service.QuizService;

@RestController
public class QuizRestController {

	private final String MAIN_PATH = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	private List<Libro> LIBRI = new ArrayList<Libro>();

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = "/domanda", method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda insertDomanda(@RequestBody Domanda domanda) {
		boolean isNew=false;
		List <Domanda> dOut=new ArrayList<Domanda>();
		System.out.println("Inizio");
		try {
			LIBRI = quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Libro l : LIBRI) {
			if(l.getIdBook().equals(domanda.getBook())){
				dOut.add(domanda);
				quizService.caricaDomande(l, dOut);
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
			quizService.createLibro(libro);
			quizService.caricaDomande(libro, dOut);
		}

		return domanda;
	}

	@RequestMapping(value = "/domanda", method = RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> getAllDomande() {

		List<Libro> libri = new ArrayList<Libro>();

		try 
		{
			libri = quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));

			for (Libro l : libri) {
				l.setDomande(quizService.getLibriCarichi(l));
			}
		}catch(Exception e){
			e.printStackTrace();
		}


		return libri.get(0).getDomande();
	}

	@RequestMapping(value = "/domanda/{id}", method = RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda getDomanda(@PathVariable String id) {
		Domanda dOut=new Domanda();	
		try 
		{
			List<Libro> libri= quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));

			for (Libro l : libri) {
				l.setDomande(quizService.getLibriCarichi(l));
				for (Domanda d : l.getDomande()) {
					if (d.getId().trim().equals(id.trim()))dOut= d;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dOut;	
	}

	@RequestMapping(value = "/capitolo/{id}", method = RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> getDomandaFromCapitolo(@PathVariable String id) {
		List <Domanda> dOut=new ArrayList<Domanda>();
		dOut.clear();
		String chapter = id.split("-")[1];
		String idBook = id.split("-")[0];
		try 
		{
			List<Libro> libri= quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));

			for (Libro l : libri) {
				if(l.getIdBook().equals(idBook))
					l.setDomande(quizService.getLibriCarichi(l));
				for (Domanda d : l.getDomande()) {
					if(chapter.equals(d.getChapter()))dOut.add(d);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dOut;
	}

	@RequestMapping(value = "/domanda/{id}", method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda updateDomanda(@RequestBody Domanda domanda, @PathVariable String id) {

		List <Domanda> dUpdate=new ArrayList<Domanda>();

		try 
		{
			List<Libro> libri= quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));
			boolean foundIt = false;
			forLibri:
				for (Libro l : libri) {
					l.setDomande(quizService.getLibriCarichi(l));
					for (Domanda d : l.getDomande()) {
						if (d.getId().trim().equals(id.trim())) {
							dUpdate.add(domanda);
							foundIt=true;
						}else if(d.getChapter().equals(id.split("-")[1])) {dUpdate.add(d);}
					}

					if (foundIt) {
						quizService.ricaricaDomande(l, dUpdate);
						break forLibri;
					}
				}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return domanda;

	}

	@RequestMapping(value = "/domanda/{id}", method = RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda deleteDomanda(@PathVariable String id) {

		List <Domanda> dUpdate=new ArrayList<Domanda>();
		Domanda dom = null;
		try 
		{
			List<Libro> libri= quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));
			System.out.println("libri list size: "+libri.size());
			boolean foundIt = false;

			forLibri:
				for (Libro l : libri) {
					if(l.getIdBook().equals(id.split("-")[0])) {
						l.setDomande(quizService.getLibriCarichi(l));

						for (Domanda d : l.getDomande()) {
							if (d.getId().equals(id.trim())) {
								dom = new Domanda(l.getTitle(),d.getChapter(),d.getQuestion(), new ArrayList<Risposta>());
								dUpdate.add(dom);
								foundIt=true;
							}else if(d.getChapter().equals(id.split("-")[1])) {dUpdate.add(d);}
						}
						
						if (foundIt) {
							quizService.ricaricaDomande(l, dUpdate);
							break forLibri;
						}
					}
				}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dom;
	}
}


