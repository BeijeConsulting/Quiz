package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.Result;
import it.beije.quiz.service.ResultService;


@RestController
public class UserHomeRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResultService resultService;
	
	
	@GetMapping("/history")
	public List<Result> getUserHistory(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		log.info("user id: "+session.getAttribute("userid"));
		if(session==null) return null;
		else {

			List<Result> history = resultService.findByUserId((Integer)session.getAttribute("userid"));
			return history;
		}
	}
	
	
	
}
