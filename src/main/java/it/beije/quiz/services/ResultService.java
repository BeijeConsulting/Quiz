package it.beije.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.repositories.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
}