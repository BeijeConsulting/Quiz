package it.beije.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
}
