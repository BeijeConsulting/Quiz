package it.beije.quiz.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Risposta;
import it.beije.quiz.service.RispostaService;

@RestController
@RequestMapping("/rest")
public class RispostaRestController {
	
	@Autowired
	private RispostaService rispostaService;
	
	@GetMapping("/risposte/domanda/{idDomanda}")
	public List<Risposta> getRisposte(@PathVariable Long idDomanda) {
		List<Risposta> risposte = rispostaService.findByIdDomanda(idDomanda);
		return risposte;
	}
	
}
