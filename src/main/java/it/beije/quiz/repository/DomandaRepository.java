package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Domanda;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, Long> {

	List<Domanda> findByBook(String book);
	List<Domanda> findByBookAndChapter(String book, int chapter);

}
