package it.beije.quiz.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.services.LibroService;
import it.beije.quiz.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LibroService libroService;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public List<> home() {
//		
//		List<> libri = libroRepository.findAll();
//		return libri;
//	}

}
