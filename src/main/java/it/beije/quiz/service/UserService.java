package it.beije.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.quiz.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository resultRepository;
	
}
