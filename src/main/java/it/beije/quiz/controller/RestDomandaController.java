package it.beije.quiz.controller;

import java.io.IOException;
import java.util.Arrays;
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
	
//	@GetMapping("/domanda")
//	public List<Domanda> domande(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {		
//			String libro = request.getParameter("libro");
//			List<String> capitoli = Arrays.asList(request.getParameterValues("capitolo"));
//			System.out.println("Capitoli: " + capitoli);
//			List<Domanda> domande = domandaService.findByBookAndChapters(libro, capitoli);
//			System.out.println("Domande: " + domande);
//			model.addAttribute("capitoli", capitoli);
//			model.addAttribute("libro", libro);
//			//response.sendRedirect("./domanda");
//			return domande;
//			
//		} else {
//			return null;
//		}
//	}
}
