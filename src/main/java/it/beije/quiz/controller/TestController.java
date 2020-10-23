package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.quiz.entity.Test;
import it.beije.quiz.entity.User;
import it.beije.quiz.model.Storico;
import it.beije.quiz.service.StoricoService;
import it.beije.quiz.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping(value="/testhistory")
	public String storicoprestiti(Model model, HttpServletRequest request) {
		User user =(User)(request.getSession().getAttribute("user"));
		List<Test> test = testService.getByUser(user.getId());
		model.addAttribute("test", test);
		return "testhistory";
	}
}
