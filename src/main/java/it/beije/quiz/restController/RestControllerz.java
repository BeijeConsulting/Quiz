package it.beije.quiz.restController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerz {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Domanda> getDomande() {
		Libro l = Utils.readFileLibri().get(0);
		ArrayList<Domanda> list = l.caricaQuestions();
		return list;
	}
}