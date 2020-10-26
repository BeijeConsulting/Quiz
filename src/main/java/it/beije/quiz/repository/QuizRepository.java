package it.beije.quiz.repository;

import it.beije.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Integer countQuizByIdUtenteAndPassedTrue(Integer idUtente);

    Integer countQuizByIdUtente(Integer idUtente);

    Optional<Quiz> findById(Integer id);
}
