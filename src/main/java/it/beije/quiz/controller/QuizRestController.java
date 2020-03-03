package it.beije.quiz.controller;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Domanda;

@RestController
public class QuizRestController {

	@RequestMapping(value = "/restbest", method = RequestMethod.POST,
	consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda newDomanda(@RequestBody Domanda domanda) {
		
		return domanda;
	}
	
}
