package it.beije.quiz.controller.rest.old;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller to handle all requests regarding Question objects
 */
@RestController
@RequestMapping("/api")
public class QuestionRestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	/**
	 * REST Get method to get a Question object given a Question id
	 * @param id the id of the Question object requested
	 * @return a Question object
	 */
	@GetMapping("/getQuestions/{id}")
	public Question getQuestion(@PathVariable Integer id){
		log.debug("REST GET for Question with ID: " + id);
		return questionService.getById(id);
	}

	/**
	 * REST Get method to get a List of Question object given a Quiz object id
	 * @param idQuiz id of the Quiz object to take Questions object from
 	 * @return a List of Question object linked to the Quiz
	 */
	@GetMapping("/getQuestionsInQuiz/{idQuiz}")
	public List<Question> getQuestionsInQuiz(@PathVariable Integer idQuiz) {
		log.debug("REST GET for Questions in Quiz with Quiz ID: " + idQuiz);
		List<Answer> answerList = answerService.getAnswersFromExamId(idQuiz);
		List<Question> questionList = new ArrayList<>();
		for(Answer answer : answerList) {
			Question question = questionService.getById(answer.getIdQuestions());
			questionList.add(question);
		}
		return questionList;
	}
}