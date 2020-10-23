package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.entity.QNA;
import it.beije.quiz.entity.Question;

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
	@RequestMapping(value = "/newexam", method = RequestMethod.GET)
	public String index() {
		return "newexam";
	}
	
	
//	@RequestMapping(value="/exam", method = RequestMethod.GET)
//	public String createExam() {
//		return "exam";
//	}
	
	@RequestMapping(value="/exam", method = RequestMethod.POST)
	public String createExam(HttpServletRequest request) {
		//TODO parsing delle impostazioni per l'esame da creare
		HttpSession session = request.getSession();
		List<QNA> exam = null; //TODO N domande random dal database
		session.setAttribute("exam", exam);
		session.setAttribute("index", new Integer(0));
		session.setAttribute("tot", new Integer(10));
		
		return "exam";
	}
}
