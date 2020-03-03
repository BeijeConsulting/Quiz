package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Domanda;

@RestController
public class ControllerRest {
	
	@RequestMapping(value="/caricaDomande/{dirLibro}", method=RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable String dirLibro){
		List <Domanda> listaDomande= new ArrayList<Domanda>();
		
		
		
		
		return listaDomande;
		
		
	}

	
}
