package it.beije.quiz.controller;

import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.entity.User;
import it.beije.quiz.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user,HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		HttpSession session = request.getSession();
		String returnPath = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user = userService.checkLogin(email, password);
		if(user!=null) {
			session.setAttribute("firstName", user.getName());
			session.setAttribute("lastName", user.getSurname());
			session.setAttribute("userid", user.getId());
			session.setAttribute("auth", true);
			returnPath = "myaccount";
		} else {
			model.addAttribute("error", "ERROR: Email or password incorrect");
			returnPath = "login";
		}
		
		return returnPath;
	}
}
