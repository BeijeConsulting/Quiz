package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.model.Quiz;


@Repository
public interface EsamiRepository extends JpaRepository<Quiz, Integer> {

	List<Quiz> findByIdUtente(Integer id_utente); //id_utente è INT su DB e Long nel model..
	
	List<Quiz> findByNomeQuiz(String nomeQuiz); //dovrebbe essere univoco ma non penso lo sia
}
