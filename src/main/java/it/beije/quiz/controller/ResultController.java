package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.entity.QNA;
import it.beije.quiz.entity.Result;
import it.beije.quiz.service.ResultService;

@Controller
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@RequestMapping(value="/result", method = RequestMethod.GET)
	public String result(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		List<QNA> exam = (List<QNA>)session.getAttribute("exam");
		LocalDateTime start = (LocalDateTime)session.getAttribute("start_time");
		LocalDateTime finish = (LocalDateTime)session.getAttribute("finish_time");
		Duration d = Duration.between((start), finish);
		long s = d.getSeconds();
		int giuste = calculateResult(exam);
		model.addAttribute("totali", session.getAttribute("totDomande"));
		model.addAttribute("giuste", giuste);
		model.addAttribute("tempo", String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60)));
		model.addAttribute("nomeEsame", session.getAttribute("nameQuiz"));
		
		resultService.save(new Result((Integer)session.getAttribute("userid"), start, finish, giuste,
				(Integer)session.getAttribute("totDomande"), (String)session.getAttribute("nameQuiz")));
		
		return "result";
	}
	
	private int calculateResult(List<QNA> exam) {
		int corrette = 0;
		for(QNA x : exam) {
			if(isCorrect(x)) corrette++;
		}
		return corrette;
	}
			
	private boolean isCorrect(QNA q) {
			String risposta = q.getUserChoice();
			String rispostaEsatta = q.getCorrects();
			
			for(int i = 0; i < risposta.length(); i++) {
				char c = risposta.charAt(i);
				if(c == ' ' || c == ',') continue;
				if(rispostaEsatta.indexOf(c) < 0) {
					return false;
				} else {
					rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
				}
			}
			return rispostaEsatta.length() == 0;
		}
}
