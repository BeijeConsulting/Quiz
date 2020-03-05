package it.beije.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;
import it.beije.quiz.Utils;
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
	
	@RequestMapping(value = "/newdomanda", method = RequestMethod.POST)
	public void insertDomanda(@RequestBody Domanda domanda) throws Exception {
		String[] path = domanda.getId().split("([|])");
		Utils.writeDomandeXML(domanda, quizService.baseDirectory + path[0] + "\\domande_cap" + path[1] + ".xml");
	}
	
	@RequestMapping(value = "/newdomande", method = RequestMethod.POST)
	public void insertDomande(@RequestBody List<Domanda> domande) throws Exception {
		for(Domanda d : domande) {
			String[] path = d.getId().split("([|])");
			Utils.writeDomandeXML(d, quizService.baseDirectory + path[0] + "\\domande_cap" + path[1] + ".xml");
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateDomanda(@RequestBody Domanda domanda) throws Exception {

		Utils.deleteElement(domanda, quizService.baseDirectory + domanda.getId().split("([|])")[0] + "\\domande_cap" + domanda.getChapter() + ".xml");
		Utils.writeDomandeXML(domanda, quizService.baseDirectory + domanda.getId().split("([|])")[0] + "\\domande_cap" + domanda.getChapter() + ".xml");
		
		quizService.ricaricaDomande();
	}
	
	@RequestMapping(value = "/delete/{libro}/{cap}/{question}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String libro, @PathVariable String cap, @PathVariable String question) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		String id = libro + "|" + cap + "|" + question;
		
		List<Domanda> domande = quizService.getDomande();
			
		if(libro != null) {
			domande = domandeLibro(domande, libro);
			System.out.println("Libro: " + domande.size());
			
			if(cap != null) {
				domande = domandeCapitolo(domande, cap);
				System.out.println("Cap: " + domande.size());
				
				if(question != null) {
					domande = domandeQuestion(domande, question);
					System.out.println("Dom: " + domande.size());
				}
			}
		}
		
		if(domande.size() == 1) {
			Utils.deleteElement(domande.get(0), quizService.baseDirectory + libro + "\\domande_cap" + cap + ".xml");
		}
	
		quizService.ricaricaDomande();
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
