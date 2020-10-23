package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.quiz.utils.Converter;
import it.beije.quiz.service.QuizService;
import it.beije.quiz.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.model.User;

@Controller
@SessionScope
public class QuizController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	// Creato layer Service per togliere la logica dal Controller
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private Converter converter;

	/**
	 * Controller pagina iniziale. Carica il file xml e mostra le domande disponibili
	 * @return la pagina di index
	 */

//	@RequestMapping(value = "/load", method = RequestMethod.POST)
//	public String init(Model model,
//					   HttpSession session,
//					   HttpServletRequest request,
//					   @Param("questions") String[] questions) {
//		System.out.println("Richiesta POST per /load.");
//		if (questions != null && questions.length > 0){
//			quizService.loadDomande(model, questions);
//			quizService.createQuiz(session, request);

//		}
//	}
//
//	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
//	public String signUp() {
//		log.info("signUn get...");
//
//		return "signUp";
//	}
//
//	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
//	public String signUp(User newUser, HttpServletRequest request, HttpServletResponse response, Model model) {
//		log.info("signIn post...");
//
//		userService.insert(newUser);
//		log.debug("user:" +newUser);
//
//		if(newUser != null) {
//			request.getSession().setAttribute("userBean", newUser);
//			return "index";
//		}else {
//			System.out.println("non c'�. utente: "+newUser);
//			model.addAttribute("errore", "CREDENZIALI ERRATE");
//			return "signUp";
//		}
//	}
//
//	/**
//	 * Converte tutti gli XML e li inserisce nel database
//	 */
//	@RequestMapping(value = "/converter", method = RequestMethod.GET)
//	public String converter() {
//		converter.convertAll();
//		return "index";
//	}

	/**
	 * Converte tutti gli XML e li inserisce nel database
	 */
	
	@RequestMapping(value = "/testdomanda", method = RequestMethod.GET)
	public String testdomanda() {
		return "domandaAjax";
	}
}
