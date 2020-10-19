package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.quiz.model.Storico;
import it.beije.quiz.model.Utente;
import it.beije.quiz.service.StoricoService;

@Controller
public class StoricoController {

	@Autowired
	private StoricoService storicoService;
	
	@GetMapping(value="/storicoesiti")
	public String storicoprestiti(Model model, HttpServletRequest request) {
		Utente utente =(Utente)(request.getSession().getAttribute("utente"));
		List<Storico> storico = storicoService.getByUtente(utente.getId());
		model.addAttribute("storico", storico);
		return "storicoesiti";
	}
}
