package it.beije.quiz.repository;

import it.beije.quiz.model.Domanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, Integer> {
    List<Domanda> findByBookIdInAndChapterIn(List<Integer> bookId, List<Integer> chapter);

    List<Domanda> findByBookIdAndChapter(Integer bookId, Integer chapter);

    Integer countByBookIdInAndChapterIn(List<Integer> bookId, List<Integer> chapter);

    Integer countByBookIdAndChapter(Integer bookId, Integer chapter);

}
