package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.QNA;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Result;
import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.ResultService;


@RestController
public class UserHomeRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultService resultService;
	
	
	@GetMapping("/history")
	public List<Result> getUserHistory(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null) return null;
		else {
			System.out.println("user id: "+session.getAttribute("userId"));
			//session.setAttribute("userId", new Integer(1));
			List<Result> history = resultService.findByUserId((Integer)session.getAttribute("userId"));
			return history;
		}
	}
	
	
	
}
