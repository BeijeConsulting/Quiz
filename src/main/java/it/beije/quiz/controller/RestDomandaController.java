package it.beije.quiz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;

@RestController
public class RestDomandaController {

	@Autowired
	private DomandaService domandaService;
	
	@GetMapping("/domanda")
	public String libro(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam String libro, @RequestParam List<String> capitoli) throws IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {			
			List<Domanda> domande = domandaService.findByBookAndChapters(libro, capitoli);
			model.addAttribute("capitoli", capitoli);
			model.addAttribute("libro", libro);
			response.sendRedirect("domanda.jsp");
			return "libro";
			
		} else {
			return "forbidden";
		}
	}
}
