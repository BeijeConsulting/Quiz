package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.UserAnswer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.UserAnswerRepository;

@Service
public class UserAnswerService {

	@Autowired
	private UserAnswerRepository userAnswerRepo;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Transactional
	public List<UserAnswer> createAnswers(List<Question> questions, Integer quizId) {
		for(int i = 0; i < questions.size(); i++) {
			UserAnswer ua = new UserAnswer();
			ua.setQuestionId(questions.get(i).getQuestionId());
			ua.setQuizId(quizId);
			log.debug(""+ua.getQuestionId());
			userAnswerRepo.saveAndFlush(ua);
		}
		return userAnswerRepo.findByQuizId(quizId);		
	}
	
	@Transactional
	public void saveAll(List<UserAnswer> userAnswers) {
		for(UserAnswer ua : userAnswers) {
			userAnswerRepo.saveAndFlush(ua);
		}
	}
	
// Credo non serva piu - inoltre bisognerebbe adattare int test a Integer quizId se servisse ancora
//	public int getCorrect(int test) {
//		return answerRepo.findByTestAndCorrect(test, true).size();
//	}

	public List<UserAnswer> selectAllByQuizId(Integer quizId) {
		return userAnswerRepo.findByQuizId(quizId);
	}

	public UserAnswer selectByQuizIdAndQuestionId(Integer quizId, Integer questionId) {
		Optional<UserAnswer> o = userAnswerRepo.findByQuizIdAndQuestionId(quizId, questionId);
		return o.isPresent() ? o.get() :null;
	}
	
	//if given answer alredy exists on db update it, otherwise do nothing and return null
	@Transactional
	public UserAnswer updateAnswer(UserAnswer ua) {
		Optional<UserAnswer> o = userAnswerRepo.findById(ua.getUserAnswerId());
		if(o.get() == null) {
			return null;
		}
		o.get().setAnswer(ua.getAnswer());
		return userAnswerRepo.saveAndFlush(o.get());
	}
	
	//if given answer is not null and is valid, make it persistent, otherwise throw IllegalArgumentException
	@Transactional
	public void insert(UserAnswer ua) {
		if (ua == null) {
			log.debug("Received answer is null");
			throw new IllegalArgumentException("bean answer null");
		}
		if (isValidAnswer(ua)) {
			userAnswerRepo.save(ua);
			log.info("risposta data inserita!");
			log.debug("dati UserAnswer mancanti o corrotti");
		} else throw new IllegalArgumentException("dati UserAnswer mancanti o corrotti");
	}
	
	private boolean isValidAnswer(UserAnswer ua) {
		boolean valid = false;
		if(ua.getUserId() != null &&
				ua.getQuizId() != null &&
				ua.getQuestionId() != null &&
				(!"".equals(ua.getAnswer()))) {
			valid=true;
		}
		return valid;
	}
}