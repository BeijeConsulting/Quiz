package it.beije.quiz.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.RisposteDateService;

@RestController
@RequestMapping("/rest")
public class RisposteDateRestController {

	@Autowired
	private RisposteDateService risposteDateService;
	
	@GetMapping("/rispostedate/quiz/{idQuiz}")
	public List<RisposteDate> getRisposteDateByIdQuiz(@PathVariable Integer idQuiz) {
		return risposteDateService.findByIdEsame(idQuiz);
	}
}
