package it.beije.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.QuizService;


@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = {"/domande", "/domande/{libro}", "/domande/{libro}/{capitolo}",
	"/domande/{libro}/{capitolo}/{question}"}, method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable(required = false) String libro, 
			@PathVariable(required = false) String capitolo, 
			@PathVariable(required = false) String question) throws ParserConfigurationException, SAXException, IOException {

		List<Domanda> domande = quizService.getDomande();
		
		if(libro != null) {
			domande = domandeLibro(domande, libro);
			System.out.println("Libro: " + domande.size());
			
			if(capitolo != null) {
				domande = domandeCapitolo(domande, capitolo);
				System.out.println("Cap: " + domande.size());

				if(question != null) {
					domande = domandeQuestion(domande, question);
					System.out.println("Dom: " + domande.size());
				}
			}
		}

		return domande;
	}

	private List<Domanda> domandeLibro(List<Domanda> d, String libro) {
		List<Domanda> domande = new ArrayList<Domanda>();
		for(Domanda q : d) {
			if(q.getId().contains(libro + "|")) {
				domande.add(q);
			}
		}
		return domande;
	}

	private List<Domanda> domandeCapitolo(List<Domanda> d, String capitolo) {
		List<Domanda> domande = new ArrayList<Domanda>();
		for(Domanda q : d) {
			if(q.getChapter().equals(capitolo)) {
				domande.add(q);
			}
		}
		return domande;
	}

	private List<Domanda> domandeQuestion(List<Domanda> d, String question) {
		List<Domanda> domande = new ArrayList<Domanda>();
		for(Domanda q : d) {
			if(q.getQuestion().equals(question)) {
				domande.add(q);
			}
		}
		return domande;
	}
}
