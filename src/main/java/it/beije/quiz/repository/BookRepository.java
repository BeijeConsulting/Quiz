package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
