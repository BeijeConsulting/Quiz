package it.beije.quiz.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Test;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	//private LocalTime time = null;
	
	/*
	 * starts the test beginning from the question in index (usually 0)
	 */
	@GetMapping(value="/question/{index}")
	public String loadAnswer(@PathVariable int index, Model model, HttpServletRequest request) {	
		questionService.setTimer(model);
		HttpSession session = request.getSession();
		Test test = (Test)session.getAttribute("test");
		return questionService.loadQuestion(model, index, test);
	}
	
	@PostMapping(value = "/question")
	public String answer(Model model, HttpServletRequest request) {
		questionService.setTimer(model);
		HttpSession session = request.getSession();
		Test test = (Test)session.getAttribute("test");
		Enumeration<String> answers =  request.getParameterNames();
		StringBuilder builder = new StringBuilder();
		int index = 0;
		while(answers.hasMoreElements()) {
			String s = answers.nextElement();
			if(s.equalsIgnoreCase("index")) index = Integer.parseInt(request.getParameter(s));
			else {
				s = request.getParameter(s);
				builder.append(s);
			}
		}
		Answer a = questionService.getAnswer(index);
		a.setAnswer(builder.toString());
//		setTimer(model);		
		return questionService.loadQuestion(model, ++index, test);
	}
	
	@GetMapping(value = "/result")
	public String result(Model model, HttpServletRequest request) {
		Test test = (Test)(request.getSession().getAttribute("test"));
		return questionService.result(model, test/*, time*/);
	}
	
	
}
