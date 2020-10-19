package it.beije.quiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UtenteController {
	
		@RequestMapping(value = "/log", method = RequestMethod.GET)
		public String login() {
			System.out.println("Redirect..");
			return "login";
		}
		

}
