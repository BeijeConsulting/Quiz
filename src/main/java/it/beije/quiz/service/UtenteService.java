package it.beije.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.model.Utente;
import it.beije.quiz.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;
	
	public Utente checkLogin(String email, String password) {
		
		Optional<Utente> o = utenteRepository.findByEmailAndPassword(email, password);
		return o.isPresent() ? o.get():null;
	}
	
	@Transactional
	public Utente register(Utente utente) {
		Optional<Utente> o = utenteRepository.findByEmail(utente.getEmail());
		Utente ret = null;
		if(!o.isPresent()) {
			utenteRepository.save(utente);
			ret = utente;
		} else if(o.isPresent()) {
			ret = null;
		}
		return ret;
	}
}
