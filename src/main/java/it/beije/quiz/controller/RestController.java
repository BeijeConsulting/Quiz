package it.beije.quiz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
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
		Utils.writeDomandeXML(domanda, "C:\\Users\\Padawan04\\git\\Quiz\\domande\\" + path[0] + "\\domande_cap" + path[1] + ".xml");
	}
	
	@RequestMapping(value = "/newdomande", method = RequestMethod.POST)
	public void insertDomande(@RequestBody List<Domanda> domande) throws Exception {
		for(Domanda d : domande) {
			String[] path = d.getId().split("([|])");
			Utils.writeDomandeXML(d, "C:\\Users\\Padawan04\\git\\Quiz\\domande\\" + path[0] + "\\domande_cap" + path[1] + ".xml");
		}
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
