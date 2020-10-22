package it.beije.quiz.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Optional<Question> findTopByOrderByIdDesc();
	
}