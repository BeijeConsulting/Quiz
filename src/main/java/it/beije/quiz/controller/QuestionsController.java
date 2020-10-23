package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Result;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.ResultService;


@RestController
public class QuestionsController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/questions_list/{id}")
	public List<Question> loadQuestionsBook(@PathVariable Integer id) {
		log.debug("lista di domande del libro");
		List<Question> questions = questionService.loadQuestionsBook(id);
		return questions;
	}
	
	@GetMapping("/history")
	public List<Result> getUserHistory(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("userId", new Integer(1));
		List<Result> history = resultService.findByUserId((Integer)session.getAttribute("userId"));
		return history;
	}
	
}
