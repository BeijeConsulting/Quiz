package it.beije.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.repository.DomandaRepository;
import it.beije.quiz.service.DomandaService;

import java.util.List;

@RestController
@RequestMapping("/index")
public class RestHomeController {
	
	@Autowired
	private DomandaService domandaService;
	
//	@GetMapping("/")
//	public List<Libro> getLibri() {
//		 List<Libro> libri = domandaService.getBooks();
//		 System.out.println(libri);
//		 return libri;
//	}
//	
	
	
}