package it.beije.quiz.restcontroller;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.DomandaService;
import it.beije.quiz.service.RisposteDateService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DomandaRestController {
	@Autowired
	private DomandaService domandaService;

	@Autowired
	private RisposteDateService risposteDateService;

	@GetMapping("/getDomanda/{id}")
	public Domanda getDomanda(@PathVariable Long id){
		return domandaService.getByID(id);
	}

	@GetMapping("/domande/quiz/{idQuiz}")
	public List<Domanda> getDomandeByIdQuiz(@PathVariable Integer idQuiz) {

		List<RisposteDate> risposteList = risposteDateService.findByIdEsame(idQuiz);
		List<Domanda> domandeList = new ArrayList<Domanda>();
		for(RisposteDate risposta : risposteList) {
			Domanda domanda = domandaService.getByID(risposta.getIdDomanda());
			domandeList.add(domanda);
		}

		return domandeList;
	}
}
