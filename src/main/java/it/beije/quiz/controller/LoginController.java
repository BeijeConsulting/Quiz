package it.beije.quiz.controller;

import it.beije.quiz.model.User;
import it.beije.quiz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		log.info("signIn get...");
		return "signIn";
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signIn(HttpServletRequest request,
                         Model model) {
		log.info("signUn post...");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.retrieve(email, password);
		log.debug("user:" +user);

		if(user != null) {
			request.getSession().setAttribute("userBean", user);
			return "iniziaQuiz";
		}else {
			log.error("No user");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "signIn";
		}
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		log.info("signUn get...");
		return "signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
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
