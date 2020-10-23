package it.beije.quiz.repository;
<<<<<<< HEAD
import java.util.List;
=======

import java.util.List;

>>>>>>> branch 'quizKirolosmater' of https://github.com/BeijeConsulting/Quiz
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.beije.quiz.model.Risposta;
@Repository
public interface RispostaRepository extends JpaRepository<Risposta, Long> {
<<<<<<< HEAD
	List<Risposta> findByBookAndChapter(String book, int chapter);
}
=======
	List<Risposta> findByBookAndChapterAndQuestion(String book, int chapter, int question);
}
>>>>>>> branch 'quizKirolosmater' of https://github.com/BeijeConsulting/Quiz
