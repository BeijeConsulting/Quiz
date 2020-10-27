package it.beije.quiz.controller.rest;

import java.util.List;

import it.beije.quiz.entity.Test;
import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller to handle all requests regarding Quiz objects
 */
@RestController
@RequestMapping("/api")
public class QuizRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private TestService testService;

	@Autowired
	private AnswerRepository answerRepository;

	/**
	 * REST Get method which returns all Quiz object linked to a User
	 * @param id_user the id of the User
	 * @return a List of Quiz object given by that User
	 */
	@GetMapping(value = "/getUserExams/{id_user}")
	public List<Test> getEsamiUtente(@PathVariable Integer id_user) {
		List<Test> esami = testService.getQuizByUserId(id_user);
		log.debug("Requested Quiz from User: " + id_user + ". Amount of Quiz: " + esami.size());
		return esami;		
	}

	/**
	 * REST Get method which returns a Quiz object given its id
	 * @param id the id of the Quiz object
	 * @return a Quiz object
	 */
	@GetMapping(value = "/getExamById/{id}")
	public Test getEsameById(@PathVariable Integer id) {
		Test quiz = testService.getEsameById(id);
		log.debug("Requested Quiz ID: " + id + ". Got Quiz: " + quiz);
		return quiz;
	}

	/**
	 * REST Get method which returns a Quiz object given its name
	 * @param nameQuiz name of the Quiz requested
	 * @return a Quiz object
	 */
	@GetMapping(value = "/getExamByName/{nameQuiz}")
	public Test getEsameByName(@PathVariable String nameQuiz) {
		Test quiz = testService.getEsameByNomeQuiz(nameQuiz);
		log.debug("Requested Quiz by name: " + nameQuiz + ". Got Quiz: " + quiz);
		return quiz;
	}

	/**
	 * REST Post method which save a Quiz object in the Database
	 * @param quiz the Quiz object to save
	 * @return the Quiz object saved on the Database
	 */
	@PostMapping("/saveQuiz")
	public Test saveQuiz(@RequestBody Test quiz) {
		log.debug("Saving this Quiz: " + quiz);
		testService.saveQuiz(quiz);
		log.debug("Saved Quiz: " + quiz);
		return quiz;
	}

	/**
	 * REST Get method to return the count of all Quiz passed by a User
	 * @param userId the id of the User to check
	 * @return the count of all passed (correct) Quiz from the User
	 */
	@GetMapping("/getPassedExams/{userId}")
	public Integer getPassedQuizByUser(@PathVariable Integer userId){
		log.debug("Requested all Passed Exams by User ID: " + userId);
		return testService.countCorrectQuizByUser(userId);
	}

	/**
	 * REST Get method to return the count of all Quiz given by a User
	 * @param userId the id of the User to check
	 * @return the count of all Quiz done by the User
	 */
	@GetMapping("/getGivenExams/{userId}")
	public Integer getAllQuizByUser(@PathVariable Integer userId){
		log.debug("Requested all Quiz given by User ID: " + userId);
		return testService.countQuizByUser(userId);
	}

	/**
	 * REST Get method to return the time in seconds available for a Quiz
	 * @param quizId the id of the Quiz
	 * @return the time in seconds
	 */
	@GetMapping("/getQuizTimer/{quizId}")
	public long getSecondsForExam(@PathVariable Integer quizId){
		log.debug("Requested Timer for Quiz ID: " + quizId);
		Integer domande = answerRepository.countByIdTest(quizId);
		return domande * 60 * 2L;
	}
}