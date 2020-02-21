package it.beije.quiz.model;

import it.beije.quiz.Utils;

public class Test {

	public static void main(String[] args) {
		Libro l = new Libro();
		l.setIdBook("efs");
		l.setNameDir("vvvv");
		l.setTitle("OOOK");
		Utils.createLibro(l);

	}

}
