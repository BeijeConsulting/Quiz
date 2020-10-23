package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String returnPath = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user = userService.checkLogin(email, password);
		if(user!=null) {
			session.setAttribute("name", user.getName());
			session.setAttribute("surname", user.getSurname());
			session.setAttribute("userid", user.getId());
			session.setAttribute("auth", true);
			returnPath = "userhome";
		} else {
			model.addAttribute("error", "ERROR: Email or password incorrect");
			returnPath = "login";
		}
		
		return returnPath;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return "login";
	}
}
