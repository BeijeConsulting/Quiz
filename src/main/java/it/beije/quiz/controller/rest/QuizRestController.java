package it.beije.quiz.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/question/{id}")
	public Question getQuestion(@PathVariable Integer id) {
		return questionService.getById(id);
	}
	
	@PutMapping("/answer")
	public void saveAnswer(@RequestBody Answer answer) {
		if(answer!=null) answerService.updateAnswer(answer);
	}
	
//	@GetMapping("/submit")
//	public Result submitQuiz() {
//	TODO calcolare esito, salvare esame sostenuto su database e mandare indietro un esito	
//	}

}
