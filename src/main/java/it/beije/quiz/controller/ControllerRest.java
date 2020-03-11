package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.QuizService;

@RestController
public class ControllerRest {

	@Autowired
	private QuizService quizService;
	@RequestMapping(value = "/domande/{dirLibro}/{capitolo}", method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable String dirLibro, @PathVariable int capitolo,
			@RequestParam(name = "nDomanda", required = false) Integer nDomanda) {
		List<Domanda> listaDomande = quizService.getDomande();
		List<Domanda> domande = new ArrayList<Domanda>();

		if (nDomanda == null) {
			for (Domanda d : listaDomande)
				if (d.getChapter() == capitolo && Utils.getDirectory(d.getId()).equals(dirLibro))
					domande.add(d);
		} else {
			String idDomanda = dirLibro + "|" + capitolo + "|" + nDomanda;

			for (Domanda d : listaDomande)
				if (d.getId().equals(idDomanda)) {
					domande.add(d);
					break;
				}

		}

		return domande;
	}
	@RequestMapping(value = "/insertListaDomande", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String insertDomande(@RequestBody List<Domanda> domande) {
		if(domande.size()==0) {
			return "INSERIRE ALMENO UNA DOMANDA!";
		}
		else if(domande.size()==1) {
			quizService.insertDomanda(domande.get(0));
			return "DOMANDA INSERITA!";
		}
		else {
			for (Domanda dom : domande) 
				quizService.insertDomanda(dom);
			}
		return "DOMANDE INSERITE!";
		
	}
	@RequestMapping(value = "/aggiornaDomanda", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> updateListaDomande(@RequestBody List<Domanda> domande,
			HttpServletResponse response) {
		List<Domanda> listaDomandeAggiornate = new ArrayList<Domanda>();
		if (domande.size() == 1) {
			listaDomandeAggiornate.add(quizService.aggiornaDomanda(domande.get(0)));
			
		} else {
			
			Domanda d = null;
			for (Domanda domanda : domande) {
				d = quizService.aggiornaDomanda(domanda);
				if (d != null)
					listaDomandeAggiornate.add(domanda);
				else {
					response.setStatus(204);
					break;
				}

			}
		}
		return listaDomandeAggiornate;
	}
	@RequestMapping(value = "/deleteDomanda", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteDomanda(HttpServletResponse response,
			@RequestParam(name = "idDomanda", required = true) String idDomanda) {

		String dirLibro = Utils.getDirectory(idDomanda);
		int capitolo = Utils.getCapitolo(idDomanda);
		int nDomanda = Utils.getNDomanda(idDomanda);
		Domanda d = getDomande(dirLibro, capitolo, nDomanda).get(0);
		if (d == null) {
			response.setStatus(204);
			return false;
		} else {
			quizService.elimina(d);
			return true;

		}

	}

}
