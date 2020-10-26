package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.model.Quiz;
import it.beije.quiz.model.User;
import it.beije.quiz.service.EsamiService;
//import it.beije.quiz.service.RisposteDateService;
import it.beije.quiz.service.UserService;

@Controller
public class HistoryController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private RisposteDateService risposteDateService;
    
	@Autowired
	private UserService userService;
	
	@Autowired
	private EsamiService esamiService;
    
    
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String storico( HttpServletRequest request, Model model) {

		List<Quiz> esami = new ArrayList<>();
		log.debug("history controller");

		if (userService.isThereUserSession(request)) {
			User utenteSession = (User)request.getSession().getAttribute("userBean");
			
			esami = esamiService.getEsamiUtente(utenteSession.getId()); 
			
			model.addAttribute("user", utenteSession);
			model.addAttribute("esami", esami);
			return "history";
		} else {
			 
			model.addAttribute("errore", "Occorre fare il login");
			return "signIn";
		}
	}
	
	@RequestMapping(value = "/quiz_review/{id}", method = RequestMethod.GET)
	public String quizReview (@PathVariable Integer id, HttpServletRequest request, Model model) {

		Quiz esame = new Quiz();
		log.debug("history controller");

		if (userService.isThereUserSession(request)) {
			User utenteSession = (User)request.getSession().getAttribute("userBean");
			
			esame = esamiService.getEsameById(id);
			
			model.addAttribute("user", utenteSession);
			model.addAttribute("esame", esame);
			return "quiz_review";
		} else {
			 
			model.addAttribute("errore", "Occore fare il login");
			return "signIn";
		}
	}
}
