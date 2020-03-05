package it.beije.quiz.restController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.Cont;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class RestControllerz {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Domanda> getDomande() { // prendo tutte domande, gestito con pattern DSingleton.
		return Cont.getInstance();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Domanda getDomandaId(@PathVariable String id, HttpServletResponse response) {
		ArrayList<Domanda> lista = Cont.getInstance();
		for (Domanda d : lista) {
			if (id.equals(d.getId()))
				return d;
		}
		response.setStatus(204); // non metcha la risorsa.
		return null;
	}

	@RequestMapping(value = "/get/{chapter}/{question}", method = RequestMethod.GET)
	public @ResponseBody Domanda getDomanda(@PathVariable String chapter, @PathVariable Integer question,
			HttpServletResponse response) {
		ArrayList<Domanda> lista = Cont.getInstance();
		for (Domanda d : lista) {
			if (chapter.equals(d.getChapter()) && question.intValue() == d.getQuestion())
				return d;
		}
		response.setStatus(204);
		return null;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Domanda setDomanda(@RequestBody Domanda domanda, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		List<Libro> listL = Utils.readFileLibri();
		for (Libro l : listL)
			if (domanda.getBook().equals(l.getTitle())) {
				String fileName = isNumber(domanda.getChapter()) ? ("domande_cap_" + domanda.getChapter())
						: ("domande_" + domanda.getChapter());
				Utils.caricaDomande(l, fileName, domanda);
				Cont.close();
				return domanda;
			}
		response.setStatus(204);
		return null;
	}

	@RequestMapping(value = "/get/{bookDir}/{chapter}/{id}", method = RequestMethod.PUT)
	public @ResponseBody Domanda editDomanda(@PathVariable String bookDir, @PathVariable String chapter,
			@PathVariable String idDomandaToEdit, @RequestBody Domanda newDomanda, HttpServletResponse response) {
		ArrayList<Domanda> lista = Cont.getInstance();
		for (Domanda d : lista) {
			if (idDomandaToEdit.equals(d.getId()))
//				d.editXML(newDomanda, bookDir);

			// C:\\Users\\Gabriele\\git\\Quiz\\domande\\oca_manual\\domande_Assessment_Test.xml
			// per postna http://localhost:8080/quiz/oca_manual/domande_Assessment_Test
			return d;
		}
		response.setStatus(204);
		return null;
	}

	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}