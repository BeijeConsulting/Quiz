package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(HttpServletRequest request) {
//		HttpSession session = request.getSession(false);
//		if(session==null) {
//			return "login";
//		} else {
//			return "home";
//		}
//	}
	
	@RequestMapping(value="/summary", method = RequestMethod.GET)
	public void userSummary() {
		//TODO return summary for all user exams with stats, meant to be called by ajax
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
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		System.out.println("index get");
		return "index";
	}
	
	@RequestMapping(value="/load_quiz", method = RequestMethod.POST)
	public String init(Model model, HttpSession session, HttpServletRequest request, @Param("questions") String[] questions) {
		System.out.println("Richiesta POST per load_quiz");
		if (questions != null && questions.length > 0){
//			quizService.loadDomande(model, questions);
//			quizService.createQuiz(session, request);
		}
		return "avviaTest";
	}

}
