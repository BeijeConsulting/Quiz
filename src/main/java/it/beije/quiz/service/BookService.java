package it.beije.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Book;
import it.beije.quiz.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	public Book getBook(String bookTitle) {
		Optional<Book> optBook = bookRepo.findByTitle(bookTitle);
		return optBook.orElse(null);
	}
}
