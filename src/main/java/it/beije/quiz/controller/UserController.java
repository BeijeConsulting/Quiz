package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.quiz.entity.User;
import it.beije.quiz.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String getLogin() {
			log.debug("Redirect to index page (get)");
			return "index";
		}
		
		@RequestMapping(value = "/log", method = RequestMethod.POST)
		public String postLogin(HttpServletRequest request, Model model, @RequestParam String email, @RequestParam String password){
			User utente = userService.login(email, password);
			HttpSession session = request.getSession();
			if(utente==null) {
				model.addAttribute("errore", "Credenziali Errate");
				log.debug("credenziali non valide");
				return "login";
			}
			else { 
				session.setAttribute("user", utente);
				return "home";
			}
		}
		
		@GetMapping(value ="/home")
		public String home() {
			log.debug("Redirect to home page");
			return "home";
		}
		
	
		
		@RequestMapping(value = "/log", method = RequestMethod.GET)
		public String backHome() {
			log.debug("Redirect to login page");
			return "login";
		}
		
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("utente");
			return "index";			
		}
		
		@PostMapping(value="/newuser")
		public String newUser(User newuser) {
			userService.insert(newuser);
			return "index";
		}
		
		@GetMapping(value="/newuser")
		public String newUser() {
			return "newuser";
		}

}
