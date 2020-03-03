package it.beije.quiz.restController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.Cont;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestControllerz {
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Domanda> getDomande() {

		return Cont.getInstance();
	}
	
	@RequestMapping(value = "/get/{chapter}/{question}", method = RequestMethod.GET)
	public @ResponseBody Domanda getDomanda(@PathVariable String chapter, @PathVariable Integer question,
			HttpServletResponse response) {
		ArrayList<Domanda> lista = Cont.getInstance();
		for(Domanda d : lista) {
			if(chapter.equals(d.getChapter()) && question.intValue()==d.getQuestion()) 
				return d;
		}
		response.setStatus(204);
		return null;
	}
	
	@RequestMapping(value = "/new/", method = RequestMethod.POST)
	public @ResponseBody Domanda setDomanda(@RequestBody Domanda domanda, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		//domanda = new ObjectMapper().readValue(domanda.toJSON(), Domanda.class);
		List<Libro> listL = Utils.readFileLibri();
		for(Libro l : listL)
			if(domanda.getBook().equals(l.getTitle())) {
				String fileName = isNumber(domanda.getChapter()) ? ("domande_cap_"+domanda.getChapter()) : ("domande_"+domanda.getChapter());
				Utils.caricaDomande(l, fileName, domanda);
				Cont.close();
				return domanda;
			}
		response.setStatus(204);
		return null;
	}
	
	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}