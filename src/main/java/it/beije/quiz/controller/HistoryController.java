package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.model.User;
import it.beije.quiz.service.RisposteDateService;

@Controller
public class HistoryController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RisposteDateService risposteDateService;
    
    
//	@RequestMapping(value = "/history", method = RequestMethod.GET)
//	public String storico( HttpServletRequest request, Model model) {
//		Integer idUtente = 0;
//		List<RisposteDate> quiz = new ArrayList<>();
//		if (utenteService.isThereUtenteSession(request)) {
//			User utenteSession = (User)request.getSession().getAttribute("userBean");
//			
//			percorsi = quizService..(utenteSession.getId()); 
//			
//			model.addAttribute("percorsi", percorsi);
//			return "history";
//		} else {
//			 
//			model.addAttribute("errore", "Occore fare il login");
//			return "signIn";
//		}
//	}
}
