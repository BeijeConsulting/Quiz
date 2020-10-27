package it.beije.quiz.controller.rest;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.DomandaService;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.RisposteDateService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DomandaRestController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@GetMapping("/getDomanda/{id}")
	public Question getDomanda(@PathVariable Integer id){
		return questionService.getById(id);
	}

	@GetMapping("/domande/quiz/{idQuiz}")
	public List<Question> getDomandeByIdQuiz(@PathVariable Integer idQuiz) {
		// Todo sistemare
		List<Answer> risposteList = answerService.risposteEsame(idQuiz);
		List<Question> domandeList = new ArrayList<>();
		for(Answer risposta : risposteList) {
			Question domanda = questionService.getByID(risposta.getIdDomanda());
			domandeList.add(domanda);
		}
		return domandeList;
	}
}