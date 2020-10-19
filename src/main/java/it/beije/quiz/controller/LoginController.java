package it.beije.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.services.UserService;

@Controller
@SessionScope
public class LoginController {
	
	 @Autowired
	 private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {		
		return "login";
	}	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {		
		return "register";
	}	
}
