package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.Quiz;
import it.beije.quiz.repository.EsamiRepository;

@Service
public class EsamiService {
	
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private EsamiRepository esamiRepository;


	public List<Quiz> getEsamiUtente(Integer id_utente) {
		return esamiRepository.findByIdUtente(id_utente);
	}
	
	public Quiz getEsameByNomeQuiz(String nomeQuiz) {  //anche se hanno dato lo stesso nome a due 
												   // esami, restituisce solo il primo
		List<Quiz> esami = esamiRepository.findByNomeQuiz(nomeQuiz);
		return esami.size() > 1 ? esami.get(0) : null;
	}
	
	public Quiz getEsameById(Integer id) {
		Optional<Quiz> risposta = esamiRepository.findById(id);
		return risposta.orElse(null);
	}
	
	
	//@Transactional
	public void insert(Quiz esame) {
		if (esame == null) {
			throw new IllegalArgumentException("bean esame null");
		}
		if (!"".equals(esame.getIdUtente().toString()) ||
				!"".equals(esame.getNomeQuiz())  ) {
	
			esamiRepository.save(esame);
			log.info("risultati esame inseriti!");
			
		} else throw new IllegalArgumentException("dati esame non presenti");
	}

}
