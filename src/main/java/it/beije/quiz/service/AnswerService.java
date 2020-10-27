package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

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
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional
	public List<Answer> createAnswers(List<Question> questions, int test_id) {
		for(int i = 0; i < questions.size(); i++) {
			Answer a = new Answer();
			a.setInd(i);
			a.setQuestion(questions.get(i).getId());
			a.setTest(test_id);
			log.debug(""+a.getQuestion());
			answerRepo.saveAndFlush(a);
		}
		return answerRepo.findByTest(test_id);		
	}
	
	public void saveAll(List<Answer> answers) {
		for(Answer a : answers) {
			answerRepo.saveAndFlush(a);
		}
	}
	
	public int getCorrect(int test) {
		return answerRepo.findByTestAndCorrect(test, true).size();
	}

	public List<Answer> selectAllByQuizId(Integer quizId) {
		return answerRepo.findByQuizId(quizId);
	}

	public Answer selectByQuizIdAndQuestionId(Integer quizId, Integer questionId) {
		Optional<Answer> o = answerRepo.findByQuizIdAndQuestionId(quizId, questionId);
		return o.isPresent() ? o.get() :null;
	}
	
	//if given answer alredy exists on db update it, otherwise do nothing and return null
	@Transactional
	public Answer updateAnswer(Integer id, String answer) {
		Optional<Answer> o = answerRepo.findById(id);
		if(o.get() == null) {
			return null;
		}
		o.get().setAnswer(answer);
		return answerRepo.saveAndFlush(o.get());
	}
	
	//if given answer is not null and is valid, make it persistent, otherwise throw new IllegalArgumentException
	@Transactional
	public void insert(Answer answer) {
		if (answer == null) {
			log.debug("Receiver answer is null");
			throw new IllegalArgumentException("bean answer null");
		}
		if (isValidAnswer(answer)) {
			answerRepo.save(answer);
			log.info("risposta data inserita!");
		} else throw new IllegalArgumentException("dati libro non presenti");
	}
	
	private boolean isValidAnswer(Answer a) {
		boolean valid = false;
		if(a.getId() != null && a.getQuizId() != null && a.getQuestionId() != null && (!"".equals(a.getAnswer()))) {
			valid=true;
		}
		return valid;
	}
}
