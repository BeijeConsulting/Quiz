package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Test;
import it.beije.quiz.entity.User;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Storico;
import it.beije.quiz.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	private List<Question> questions;

	private LocalTime time = null;
	
	/*
	 * starts the test beginning from the question in index (usually 0)
	 */
	@GetMapping(value="/question/{index}")
	public String loadAnswer(@RequestParam int index, Model model) {	
//		settimer
		questionService.loadQuestion(model, index);
		return "domanda";
	}
	
	@PostMapping(value = "/question")
	public String answer(Model model, Answer answer) {
		int index = answer.getIndex();
		
//		setTimer(model);		
		return questionService.loadQuestion(model, ++index);
	}
	
	@GetMapping(value = "/result")
	public String result(Model model, HttpServletRequest request) {
		Test test = (Test)(request.getSession().getAttribute("test"));
		return questionService.result(model, test/*, time*/);
	}
	
	
}
