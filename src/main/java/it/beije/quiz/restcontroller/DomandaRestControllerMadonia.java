package it.beije.quiz.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;

@RestController
@RequestMapping("/rest")
public class DomandaRestControllerMadonia {

	 @Autowired
	 private DomandaService domandaService;
	
	 private List<Domanda> listaDomande;
}
