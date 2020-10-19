package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.Utente;
import it.beije.quiz.repository.UtenteRepository;



@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;
	
	public List<Utente> loadUtenti(){
		return utenteRepository.findAll();
	}
	
	public Utente loadById(Integer id) {
		Optional<Utente> utente = utenteRepository.findById(id);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public Utente check(String email, String password) {
		Optional<Utente> utente = utenteRepository.findByEmailAndPassword(email, password);
		return utente.isPresent() ? utente.get() : null;
	}
}