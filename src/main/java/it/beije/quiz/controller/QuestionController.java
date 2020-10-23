package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Test;
import it.beije.quiz.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	//private LocalTime time = null;
	
	/*
	 * starts the test beginning from the question in index (usually 0)
	 */
	@GetMapping(value="/question/{index}")
	public String loadAnswer(@PathVariable int index, Model model) {	
//		settimer
		questionService.loadQuestion(model, index);
		return "domanda";
	}
	
	@PostMapping(value = "/question")
	public String answer(Model model, Answer answer) {
		int index = answer.getInd();
		
//		setTimer(model);		
		return questionService.loadQuestion(model, ++index);
	}
	
	@GetMapping(value = "/result")
	public String result(Model model, HttpServletRequest request) {
		Test test = (Test)(request.getSession().getAttribute("test"));
		return questionService.result(model, test/*, time*/);
	}
	
	
}
