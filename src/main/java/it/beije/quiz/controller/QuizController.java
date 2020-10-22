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

import it.beije.quiz.bean.User;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(HttpSession session) {
		if (session.getAttribute("userBean") == null) return "signIn";
		System.out.println("Richiesta GET per /.");
		return "index";
	}

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
//		return "avviaTest";
//	}

	/**
	 * Controller per la pagina che mostra la singola domanda.
	 * La domanda caricata viene presa tramite il metodo caricaDomanda
	 * @param model model per gestire il timer
	 * @param index indice della domanda richiesta
	 * @return richiede il metodo caricaDomanda per caricare la domanda
	 */
//	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
//	public String domanda(Model model,
//						  @PathVariable("index") int index) {
//		System.out.println("Richiesta GET per /domanda/index.");
//		// Sottraggo 1 all'index perchè così nell'url le domande partono da 1 e il numero
//		// corrisponde sempre al numero della domanda a schermo
//		index--;
//		quizService.setTimer(model);
//		return quizService.caricaDomanda(model, index);
//	}

	/**
	 * Post method per salvare la risposta dell'utente e richiedere la domanda successiva
	 * @param model per la gestione del timer
	 * @param request per ottenere la risposta
	 * @param index indice della domanda
 	 * @return chiama il metodo caricaDomanda per richiedere di mostrare la domanda successiva
	 */
//	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
//	public String risposta(Model model,
//						   HttpServletRequest request,
//						   @RequestParam("index") int index) {
//		System.out.println("Richiesta POST per /domanda.");
//		// Salva la risposta per la domanda
//		quizService.saveRisposte(request, index);
//		quizService.setTimer(model);
//		// Carica la domanda successiva
//		return quizService.caricaDomanda(model, ++index);
//	}


//	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
//	public String risultati(Model model) {
//		System.out.println("Richiesta GET per /risultati");
//		// Ottiene i risultati già
//		String risultati = quizService.getResults();
//		model.addAttribute("body", risultati);
//		return "risultati";
//	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		log.info("signIn get...");

		return "signIn";
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signIn(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("signUn post...");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		User user = userService.retrieve(email, password);	
		log.debug("user:" +user);
		
		if(user != null) {
			request.getSession().setAttribute("userBean", user);
			return "index";
		}else {
			System.out.println("non c'è. utente: "+ user);
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signIn";
		}
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		log.info("signUn get...");
		
		return "signUp";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(User newUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("signIn post...");

		userService.insert(newUser);
		log.debug("user:" +newUser);

		if(newUser != null) {
			request.getSession().setAttribute("userBean", newUser);
			return "index";
		}else {
			System.out.println("non c'è. utente: "+newUser);
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signUp";
		}
	}

	/**
	 * Converte tutti gli XML e li inserisce nel database
	 */
	@RequestMapping(value = "/converter", method = RequestMethod.GET)
	public String converter() {
		converter.convertAll();
		return "index";
	}
	
	@RequestMapping(value = "/testdomanda", method = RequestMethod.GET)
	public String testdomanda() {
		return "domandaAjax";
	}
}