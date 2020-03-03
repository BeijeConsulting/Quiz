package it.beije.quiz;

import java.util.ArrayList;

import it.beije.quiz.model.Domanda;

public class Cont {
	
	private static ArrayList<Domanda> listaDomande;
	
	public static ArrayList<Domanda> getInstance() {
		if(listaDomande==null) listaDomande = Utils.readFileLibri().get(0).caricaQuestions();
		return listaDomande;
	}
	
	public static void close() {
		listaDomande = null;
	}

}
