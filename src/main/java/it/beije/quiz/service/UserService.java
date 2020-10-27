package it.beije.quiz.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.entity.User;
import it.beije.quiz.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public boolean isThereUtenteSession (HttpServletRequest request) {
		User utenteSession = (User)request.getSession().getAttribute("user");
		return (utenteSession != null);
	}

	public User loadByEmail(String email) {
		Optional<User> utente = userRepository.findByEmail(email.toLowerCase());
		return utente.orElse(null);
	}
	
	public User login(String email, String password) {
	Optional<User> utente = userRepository.findByEmailAndPassword(email.toLowerCase(), password);
	return utente.orElse(null);
}
	
	public User loadById(Integer id) {
	Optional<User> utente = userRepository.findById(id);
	return utente.orElse(null);
}

@Transactional
	public void insert(User utente) {
		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		if (!"".equals(utente.getNickname()) ||
			!"".equals(utente.getEmail()) || !"".equals(utente.getPassword())) {
	
			userRepository.save(utente);
		} else throw new IllegalArgumentException("dati utente non presenti");
	}
}
