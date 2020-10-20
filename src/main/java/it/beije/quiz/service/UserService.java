package it.beije.quiz.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.bean.User;
import it.beije.quiz.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	
	public User retrieve(Long id) {
		log.debug("Retrieving user with ID " + id);
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	public User retrieve(String email, String password) {
		log.debug("Retrieving user " + email);
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		return user.isPresent() ? user.get() : null;
	}
	
	@Transactional
	public void insert(User user) {
		log.debug("Inserting " + user);
		if (user == null) {
			throw new IllegalArgumentException("This user is null");
		}
		
		// TODO Create throw for user with null fields where they can't be
		
		userRepository.saveAndFlush(user);
	}
	
	@Transactional
	public void modify(Long id, User userData) {
		log.debug(new StringBuilder().append("Modifying user with ID ").append(id).append(" as ").append(userData).toString());
		if (userData == null) {
			throw new IllegalArgumentException("This user is null");
		}
		
		// TODO Create throw for user with null fields where they can't be
		
		User user = this.retrieve(id);
		
		if (user == null) {
			String errorMsg = new StringBuilder().append("User with ID ").append(id).append(" not found").toString();
			log.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
		
		BeanUtils.copyProperties(userData, user, "id", "password");
		userRepository.saveAndFlush(user);
	}
	
	@Transactional
	public void modifyPassword(Long id, String newPassword) {
		log.debug(new StringBuilder().append("Modifying password of user with ID ").append(id).toString());
		
		User user = this.retrieve(id);
		
		if (user == null) {
			String errorMsg = new StringBuilder().append("User with ID ").append(id).append(" not found").toString();
			log.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
		
		user.setPassword(newPassword);
		userRepository.saveAndFlush(user);
	}
	
	public boolean checkPassword(Long id, String password) {
		log.debug(new StringBuilder().append("Checking password of user with ID ").append(id).toString());
		User user = this.retrieve(id);
		
		if (user == null) {
			String errorMsg = new StringBuilder().append("User with ID ").append(id).append(" not found").toString();
			log.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
		
		return password.equals(user.getPassword());
	}
}
