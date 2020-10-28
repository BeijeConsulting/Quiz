package it.beije.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	public Question getById(Integer id) {
		Optional<Question> o = questionRepo.findById(id);
		return o.isPresent() ? o.get() : null;
	}
}
