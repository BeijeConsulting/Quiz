package it.beije.quiz.service;

import java.time.Duration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.Pair;
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
			String[] possibleanswers = q.getPossibleAnswers().split(" ;;; ");
			List<Pair<String, String>> singleanswers = new ArrayList<>();
			for(int i = 0; i < possibleanswers.length;i++) {
				String[] s = (possibleanswers[i].split(" ::: "));
				singleanswers.add(new Pair<String, String>(s[0], s[1]));
			}
			
			model.addAttribute("index", index);
			model.addAttribute("questionText",Utils.formattaTesto(q.getText()));
			model.addAttribute("userAnswer", userAnswer);
			model.addAttribute("answerType", q.getAnswerType());
			model.addAttribute("singleanswers", singleanswers);
			
			return "domanda";
		}
		else {
			return "riepilogo";
		}
	}
	
	public String result(Model model, Test test/*, LocalTime time*/) {
		int counter=0;
		for (int i = 0; i < questions.size(); i++){
			boolean correct = Utils.controllaRisposta(questions.get(i).getAnswer(), answers.get(i).getAnswer());
			
			if (correct) {
				answers.get(i).setCorrect(true);
				counter++;
			} else {
				answers.get(i).setCorrect(false);
			}
			
		}
		model.addAttribute("questions", questions);
		model.addAttribute("answers", answers);
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
