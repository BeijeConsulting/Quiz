package it.beije.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional
	public List<Answer> createAnswers(List<Question> questions, int test_id) {
		for(int i = 0; i < questions.size(); i++) {
			Answer a = new Answer();
			a.setAnswerIndex(i);
			a.setIdQuestions(questions.get(i).getId());
			a.setIdTest(test_id);
			log.debug(""+a.getIdQuestions());
			answerRepo.saveAndFlush(a);
		}
		return answerRepo.findByIdTest(test_id);
	}
	
	public void saveAll(List<Answer> answers) {
		for(Answer a : answers) {
			answerRepo.saveAndFlush(a);
		}
	}
	
	public int getCorrect(int test) {
		return answerRepo.findByIdTestAndCorrectIsTrue(test).size();
	}
}
