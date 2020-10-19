package it.beije.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public Question load(Integer id) {
		Optional<Question> answer = questionRepository.findById(id);
		
		return answer.isPresent() ? answer.get() : null;
		
	}
	
public Integer lastId() {
		
		Optional<Question> question = questionRepository.findTopByOrderByIdDesc();
		
		return question.isPresent() ? question.get().getId() : null;
		
	}

	public void insert(Question question) {
		
		if(question == null) {
			throw new IllegalArgumentException("Question bean is null");
		}
		
		if(!"".equals(question.getExplanation())) {
			
			questionRepository.save(question);
			
		} else {
			throw new IllegalArgumentException("Question bean data is not valid");
		}
	}
}
