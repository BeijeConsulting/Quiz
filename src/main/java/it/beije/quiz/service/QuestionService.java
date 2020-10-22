package it.beije.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;

	public List<Question> getChapterQuestions(Integer id) {
		return questionRepo.findByChapter(id);
	}

	
}
