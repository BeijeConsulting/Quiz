package it.beije.quiz.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.Quiz;
import it.beije.quiz.service.EsamiService;

@RestController
@RequestMapping("/rest")
public class EsamiRestController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private EsamiService esamiService;

    
    //SELECT ALL BY ID_UTENTE
	@RequestMapping(value = "/esami_utente/{id_utente}", method = RequestMethod.GET)
	public List<Quiz> getEsamiUtente(@PathVariable Integer id_utente) {
		
		List<Quiz> esami = esamiService.getEsamiUtente(id_utente);
		
	log.info("esami svolti dall'utente " + id_utente + " : " + esami);
		
		return esami;		
	}
	
	//SELECT ESAME BY ID
	@RequestMapping(value = "/esame_id/{id}", method = RequestMethod.GET)
	public Quiz getEsameById(@PathVariable Integer id) {
		
		Quiz esame = esamiService.getEsameById(id);
		
		log.info("esame id: " + id + ", esame : " + esame);
		
		return esame;		
	}
	
	//SELECT ESAME BY NAME
	@RequestMapping(value = "/esame_nome/{nomeQuiz}", method = RequestMethod.GET)
	public Quiz getEsameByName(@PathVariable String nomeQuiz) {
		
		Quiz esame = esamiService.getEsameByNomeQuiz(nomeQuiz);
		
		log.info("nome esame: " + nomeQuiz + ", esame : " + esame);

		return esame;
	}
	

	//INSERT
//    	@RequestMapping(value = "/esame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/esame")
	public Quiz insertEsame(@RequestBody Quiz esame) {

		log.info("ricevo dati esame svolto" + esame);
		
		esamiService.insert(esame);
		
		return esame;
	}
}
