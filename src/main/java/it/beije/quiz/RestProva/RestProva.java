package it.beije.quiz.RestProva;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;


@RestController
public class RestProva {
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomanda(){
		List<Domanda> Listadomande = new ArrayList<Domanda>();
		Libro libro = new Libro();
		libro = Utils.readFileLibri().get(1);
		Listadomande.addAll(libro.caricaQuestions()); 
		
		return Listadomande;
	}

}
