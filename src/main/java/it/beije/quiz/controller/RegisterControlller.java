package it.beije.quiz.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.entity.User;
import it.beije.quiz.service.UserService;

@Controller
public class RegisterControlller {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register( Model model) {
		model.addAttribute("errore", "");
		
		return "/register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User u, Model model) {
		
		User utente = null;
		try {
			Optional<User> user = userService.findByEmail(u.getEmail().toLowerCase());
			
			utente = user.get();

			model.addAttribute("errore", "ACCOUNT NON CREATO: un altro account ha "
								+ "questa email.");	
			return "/register";

		} catch (NoSuchElementException nsee) {
			model.addAttribute("errore", "");
			model.addAttribute("registrato", "Ti sei registrato correttamente!");
			
			String email = u.getEmail().toLowerCase();
			u.setEmail(email);
			
			userService.insert(u);
			
			return "/my_login";
		}
	}

}
