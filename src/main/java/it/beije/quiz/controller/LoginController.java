package it.beije.quiz.controller;

import it.beije.quiz.model.User;
import it.beije.quiz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/signIn")
	public String signIn() {
		log.info("login get...");
		return "signIn";
	}

	@PostMapping(value = "/signIn")
	public String signIn(HttpServletRequest request,
                         Model model) {
		log.info("Login post...");
		String email = request.getParameter("login_email");
		String password = request.getParameter("login_password");

		User user = userService.retrieve(email, password);
		log.debug("user:" +user);

		if(user != null) {
			request.getSession().setAttribute("userBean", user);
			return "iniziaQuiz";
		}else {
			log.error("No user");
			model.addAttribute("errore", "Credenziali Errate");
			return "signIn";
		}
	}

	@GetMapping(value = "/signUp")
	public String signUp() {
		log.info("signUn get...");
		return "signUp";
	}

	@PostMapping(value = "/signUp")
	public String signUp(User newUser,
                         HttpServletRequest request,
                         Model model) {
		log.info("signIn post...");
		userService.insert(newUser);
		log.debug("user:" +newUser);

		if(newUser != null) {
			request.getSession().setAttribute("userBean", newUser);
			return "iniziaQuiz";
		}else {
			log.error("No user");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signUp";
		}
	}
}