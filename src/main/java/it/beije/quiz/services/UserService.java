package it.beije.quiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.model.User;
import it.beije.quiz.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User checkLogin(String email, String password) {
		
		Optional<User> o = userRepository.findByEmailAndPassword(email, password);
		return o.isPresent() ? o.get():null;
	}
	
	@Transactional
	public User register(User user) {
		Optional<User> o = userRepository.findByEmail(user.getEmail());
		User ret = null;
		if(!o.isPresent()) {
			userRepository.save(user);
			ret = user;
		} else if(o.isPresent()) {
			ret = null;
		}
		return ret;
	}
}
