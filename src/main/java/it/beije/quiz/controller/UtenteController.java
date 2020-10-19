package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.quiz.model.Utente;
import it.beije.quiz.service.UtenteService;

@Controller
public class UtenteController {
	@Autowired
	private UtenteService utenteService;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String getLogin() {
			log.debug("Redirect to login page (get)");
			return "login";
		}
		
		@RequestMapping(value = "/log", method = RequestMethod.POST)
		public String postLogin(HttpServletRequest request, Model model, @RequestParam String email, @RequestParam String password){
			Utente utente = utenteService.check(email, password);
			HttpSession session = request.getSession();
			if(utente==null) {
				model.addAttribute("errore", "Credenziali Errate");
				log.debug("credenziali non valide");
				return "login";
			}
			else { 
				session.setAttribute("utente", utente);
				return "home";
			}
		}
		
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("utente");
			return "login";			
		}

}
