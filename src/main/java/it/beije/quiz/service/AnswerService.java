package it.beije.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;

	public List<Answer> createAnswers(List<Question> questions, int test_id) {
		for(int i = 0; i < questions.size(); i++) {
			Answer a = new Answer();
			a.setIndex(i+1);
			a.setQuestion(questions.get(i).getId());
			a.setTest(test_id);
			answerRepo.saveAndFlush(a);
		}
		return answerRepo.findByTest(test_id);
		
	}

}
