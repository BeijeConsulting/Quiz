package it.beije.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.repository.DomandaRepository;

@Service
public class DomandaService {
	@Autowired
	DomandaRepository domandaRepository;
	
	public Domanda insert(Domanda domanda) {
		return domandaRepository.saveAndFlush(domanda);
	}
}
