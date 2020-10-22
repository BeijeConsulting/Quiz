package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null) {
			return "login";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value="/summary", method = RequestMethod.GET)
	public void userSummary() {
		//TODO return summary for all user exams with stats, meant to be called by ajax
	}
}
