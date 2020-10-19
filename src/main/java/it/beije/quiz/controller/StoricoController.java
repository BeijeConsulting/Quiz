package it.beije.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoricoController {

	
	@GetMapping(value="/storicoprestiti")
	public String storicoprestiti(Model model) {
		
		return null;
	}
}
