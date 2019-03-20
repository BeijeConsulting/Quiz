package it.beije.quiz.controller;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	/**
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index.jsp";
	}

//	@RequestMapping(value = "/StartQuiz", method = RequestMethod.GET)
//	public String start(Model model) {
////		System.out.println("User Page Requested");
////		model.addAttribute("userName", user.getUserName());
////		return "user";
//		LocalTime time = LocalTime.now();
//		//model.addAttribute("time", time);
//		
//		return "domanda.jsp?index=0";
//	}
}
