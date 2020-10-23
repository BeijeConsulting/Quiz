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

import it.beije.oort.corsa.girardi.entity.Percorso;
import it.beije.oort.corsa.girardi.entity.Utente;
import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.RisposteDateService;

@Controller
public class HistoryController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RisposteDateService risposteDateService;
    
    
//	@RequestMapping(value = "/history", method = RequestMethod.GET)
//	public String storico( HttpServletRequest request, Model model) {
//		Integer idUtente = 0;
//		List<Percorso> percorsi = new ArrayList<>();
//		if (utenteService.isThereUtenteSession(request)) {
//			Userr utenteSession = (User)request.getSession().getAttribute("userBean");
//			
//			percorsi = risposteDateService.(utenteSession.getId()); 
//			
//			model.addAttribute("percorsi", percorsi);
//			return "girardi/storico";
//		} else {
//			 
//			model.addAttribute("errore", "Occore fare il login");
//			return "girardi/my_login";
//		}
//	}
}
