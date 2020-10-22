package it.beije.quiz.controller;

import it.beije.quiz.service.QuizGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionScope
public class HomeController {
	@Autowired
	private QuizGeneratorService quizGeneratorService;

	/**
	 * Controller pagina iniziale
	 * @return la pagina di index
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(HttpSession session) {
		if (session.getAttribute("userBean") == null) return "signIn";
		System.out.println("Richiesta GET per /.");
		return "iniziaQuiz";
	}

	@PostMapping("/startQuiz")
	public String startQuiz(HttpServletRequest request, HttpSession session){
		if (session.getAttribute("userBean") == null) return "signIn";
		quizGeneratorService.createNewQuiz(request, session);
		return "domandaAjax";
	}
}