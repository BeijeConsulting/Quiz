package it.beije.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.quiz.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@GetMapping(value="/domanda")
	public String creadomanda() {
		return null;
	}
}
