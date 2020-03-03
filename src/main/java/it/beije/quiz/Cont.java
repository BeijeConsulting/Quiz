package it.beije.quiz;

import java.util.ArrayList;
import java.util.List;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

public class Cont {
	
	private List<Domanda> listaDomande = new ArrayList<>();
	
	public Cont() {
		Libro l = Utils.readFileLibri().get(0);
		listaDomande = l.caricaQuestions();
	}

}
