package it.beije.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.quiz.entity.Question;
import it.beije.quiz.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	private List<Question> questions;

	@GetMapping(value="/domanda/{id}")
	public String loadAnswer() {
		return null;
	}
	
	
}
