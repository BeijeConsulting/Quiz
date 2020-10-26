package it.beije.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {
	
	@RequestMapping(value = "/svolgiQuiz", method = RequestMethod.GET)
	public String getSvolgiQuiz() {
		return "domandaAjax";
	}
	
	@RequestMapping(value = "/svolgiQuiz", method = RequestMethod.POST)
	public String postSvolgiQuiz() {
		return "redirect:/history";
	}
}
