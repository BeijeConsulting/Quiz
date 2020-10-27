package it.beije.quiz.service;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Test;
import it.beije.quiz.repository.QuestionRepository;
import it.beije.quiz.repository.TestRepository;
import it.beije.quiz.utils.Pair;
import it.beije.quiz.utils.Utils;

@Service
public class QuestionService {
	
	private LocalTime time;

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private AnswerService answerService;
	
	private List<Question> questions;
	private List<Answer> answers;

	public Question getById(Integer id_question){
		return questionRepo.findById(id_question).orElse(null);
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<Question> getChapterQuestions(Integer id) {
		return questionRepo.findByChapter(id);
	}
	
	public Answer getAnswer(int index) {
		return answers.get(index);
	}
	
	public String loadQuestion(Model model, Integer index, Test test) {
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
			model.addAttribute("questionSize", questions.size());
			
			return "domanda";
		}
		else {
			return result(model, test);
		}
	}
	
	public String result(Model model, Test test/*, LocalTime time*/) {
		for (int i = 0; i < questions.size(); i++){
			boolean correct = Utils.controllaRisposta(questions.get(i).getAnswer(), answers.get(i).getAnswer());
			
			if (correct) {
				answers.get(i).setCorrect(true);
			} else {
				answers.get(i).setCorrect(false);
			}
			
		}
		model.addAttribute("questions", questions);
		model.addAttribute("answers", answers);

		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		long hours = diff.getSeconds()/3600;
		long minutes = diff.getSeconds()/60 - hours* 60;
		long seconds =  diff.getSeconds() - hours * 3600 - minutes * 60;
		test.setDuration(hours+":"+minutes+"."+seconds);
		
		answerService.saveAll(answers);
		int counter = answerService.getCorrect(test.getId());
		NumberFormat numForm = NumberFormat.getInstance();
		numForm.setMinimumFractionDigits(2);
		numForm.setMaximumFractionDigits(2);
		numForm.setRoundingMode(RoundingMode.CEILING);
		double score = counter * 100.0 / questions.size();
		model.addAttribute("percentage", numForm.format(score));
		boolean result = score >= 65;
		test.setResult(result);
		test.setScore(counter);
		test.setCommitted(true);
		testRepository.saveAndFlush(test);
		return "results";
	}

	// todo togliere?
	public void setTimer(Model model) {
	if (time == null) {
		time = LocalTime.now();
	}
	LocalTime now = LocalTime.now();
	Duration diff = Duration.between(time, now);
	int secondi = 2 * 60 * questions.size();
	long hours = (secondi - diff.getSeconds())/3600;
	long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
	long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;


	model.addAttribute("ore", hours);
	model.addAttribute("minuti", minutes);
	model.addAttribute("secondi", seconds);
}

	
}
