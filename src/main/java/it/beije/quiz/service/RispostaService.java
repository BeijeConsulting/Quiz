package it.beije.quiz.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.model.Risposta;
import it.beije.quiz.repository.RispostaRepository;

@Service
public class RispostaService {
	
	@Autowired
	RispostaRepository rispostaRepository;
	
	@Transactional
	public void insert(Risposta risposta) {
		rispostaRepository.save(risposta);
	}
}
