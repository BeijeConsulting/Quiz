package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
