package it.beije.quiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.Storico;
import it.beije.quiz.repository.StoricoRepository;

@Service
public class StoricoService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StoricoRepository storicoRepository;
	
	public List<Storico> getByUtente(Integer utente){
		log.debug("carico lista storico");
		return storicoRepository.findByIdUtente(utente);
	}
}
