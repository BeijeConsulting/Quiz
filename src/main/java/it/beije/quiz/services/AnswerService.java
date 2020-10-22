  
package it.beije.quiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	public Answer load(Integer id) {
		Optional<Answer> answer = answerRepository.findById(id);
		
		return answer.isPresent() ? answer.get() : null;
		
	}
	
	public Integer lastId() {
		
		Optional<Answer> answer = answerRepository.findTopByOrderByIdDesc();
		
		return answer.isPresent() ? answer.get().getId() : null;
		
	}

	public void insert(Answer answer) {
		
		if(answer == null) {
			throw new IllegalArgumentException("Answer bean is null");
		}
		
		if(!"".equals(answer.getText()) || !"".equals(answer.getValue())) {
			
			answerRepository.save(answer);
			
		} else {
			throw new IllegalArgumentException("Answer bean data is not valid");
		}
	}
	
	
}