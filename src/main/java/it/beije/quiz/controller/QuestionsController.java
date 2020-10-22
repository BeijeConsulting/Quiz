package it.beije.quiz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.Question;
import it.beije.quiz.service.QuestionService;


@RestController
public class QuestionsController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questions_list/{id}")
	public List<Question> loadQuestionsBook(@PathVariable Integer id) {
		log.debug("lista di domande del libro");
		List<Question> questions = questionService.loadQuestionsBook(id);
		return questions;
	}
}
