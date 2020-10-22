package it.beije.quiz.service;

import java.time.Duration;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Test;
import it.beije.quiz.repository.QuestionRepository;
import it.beije.quiz.repository.TestRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private TestRepository testRepository;
	
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
	
	public String loadQuestion(Model model, Integer index) {
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
	
	public String result(Model model, Test test/*, LocalTime time*/) {
		StringBuilder builder = new StringBuilder();
		int counter=0;
		for (int i = 0; i < questions.size(); i++){
			boolean correct = Utils.controllaRisposta(questions.get(i).getPossibleAnswers(), answers.get(i).getAnswer());
			
			builder.append("DOMANDA " + (i+1) + " : la tua risposta : " + answers.get(i).getAnswer() + "<br><br>");
			if (correct) {
				builder.append("Corretto <br>");
				answers.get(i).setCorrect(true);
				counter++;
			} else {
				answers.get(i).setCorrect(false);
				builder.append("La risposta esatta era " +  questions.get(i).getPossibleAnswers() + " :(<br>");
			}
			
			builder.append("<br><br>");
		}
		
		model.addAttribute("body", builder.toString());
		double score = counter * 100.0 / questions.size();
		boolean result = score >= 65;
//		LocalTime now = LocalTime.now();
//		Duration diff = Duration.between(time, now);
//		long hours = diff.getSeconds()/3600;
//		long minutes = diff.getSeconds()/60 - hours* 60;
//		long seconds =  diff.getSeconds() - hours * 3600 - minutes * 60;
//		test.setDuration(hours+":"+minutes+"."+seconds);
		test.setResult(result);
		test.setScore(counter);
		testRepository.saveAndFlush(test);
		return "results";
	}

	
}
