package it.beije.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
}
