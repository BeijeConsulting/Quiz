package it.beije.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	private List<Question> questions;
	private List<Answer> answers;
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<Question> getChapterQuestions(Integer id) {
		return questionRepo.findByChapter(id);
	}
	
	private String loadQuestion(Model model, Integer index) {
		if (index < questions.size()) {
			Question q = questions.get(index);
			Answer answer = answers.get(index);
			String userAnswer = answer.getAnswer();
			//System.out.println("risposta : " + risposta);
			if (userAnswer == null) {
				userAnswer = "";
			}
			model.addAttribute("index", index);
			model.addAttribute("questionText",Utils.formattaTesto(q.getText()));
			model.addAttribute("userAnswer", userAnswer);
			model.addAttribute("answerType", q.getAnswerType());
			model.addAttribute("possibleAnswers",q.getPossibleAnswers());
			
			return "domanda";
		}
		else {
			return "riepilogo";
		}
	}

	
}
