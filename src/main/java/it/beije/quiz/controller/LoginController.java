package it.beije.quiz.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.service.UserService;
import it.beije.quiz.entity.User;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(HttpServletRequest request, HttpServletResponse response,
//						Model model, Locale locale) throws IOException {
//		String str = login(request, response, model, locale);
//		return str;
//	}
	

	@RequestMapping(value = "/my_login", method = RequestMethod.GET)
	public String login(Model model, Locale locale) throws IOException {
		
		model.addAttribute("registrato", "");
		model.addAttribute("errore", "");
		
		return "girardi/my_login";
	}
	
	@RequestMapping(value = "/passaggio", method = RequestMethod.POST)
	public String utente(HttpServletRequest request, User u, Model model) {
		model.addAttribute("registrato", "");

		User utente = null;
		try {
		Optional<User> user = userService.findByEmailAndPassword(
							u.getEmail().toLowerCase(), u.getPassword());
		
		utente = user.get();
		} catch (NoSuchElementException nsee) {
			model.addAttribute("errore", "CREDENZIALI ERRATE");	
			return "my_login";
		}
		if (utente == null) {
			model.addAttribute("errore", "CREDENZIALI ERRATE");	
			return "my_login";
		} else {			
			request.getSession().setAttribute("user", utente);
			model.addAttribute("utente", utente);	
			return "index";
		}
	}
	
}
