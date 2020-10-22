package it.beije.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Question;

@Service
public class QuestionService {
	
	public String loadQuestion(List<Question> questions, Integer index, Model model) {
		if (index < questions.size()) {
			Question q = questions.get(index);
			String answer = q.getAnswer();
			//System.out.println("risposta : " + risposta);
			if (answer == null) {
				answer = "";
			}
			model.addAttribute("index", index);
			model.addAttribute("testoDomanda",Utils.formattaTesto(q.getText()));
			model.addAttribute("rispUtente", answer);
			model.addAttribute("answerType", q.getAnswerType());
			model.addAttribute("risposte",q.getPossibleAnswers());
			
			return "domanda";
		}
		else {
			return "riepilogo";
		}
		
	}

}
