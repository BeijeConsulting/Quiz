package it.beije.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.entity.User;
import it.beije.quiz.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User get(Integer id) {
		Optional<User> o = userRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}
	
	public User checkLogin(String email, String password) {
		Optional<User> o = userRepository.findByEmailAndPassword(email, password);
		return o.isPresent() ? o.get() : null;
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
	
	@Transactional
	public void update(String field, String value, Integer id) {
		if(!"".equals(field)&&!"".equals(value)&&id!=null) {
			User old = get(id);
			if(old != null) {
				updateField(old, field, value);
				userRepository.save(old);
			} else throw new IllegalArgumentException();
		}
	}
	
	private void updateField(User user, String field, String value) {
		switch(field) {
		case "firstName":
			user.setName(value);
			break;
		case "lastName":
			user.setSurname(value);
			break;
		case "email":
			user.setEmail(value);
			break;
		case "password":
			user.setPassword(value);
			break;
		
		}
	}
}
