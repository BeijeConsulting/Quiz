package it.beije.quiz.repository;

import it.beije.quiz.model.Domanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, Long> {
    List<Domanda> getAllByBookIdInAndChapterIn(List<Integer> bookId, List<Integer> chapter);
}
