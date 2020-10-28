package it.beije.quiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	//Queste funzionalità sono state spostate nell'entity Partecipate.
	//List<Quiz> findByUserId(Integer id_user);
	//Integer countByUserId(Integer user_id);
	//Integer countByUserIdAndResultIsTrue(Integer user_id);
	Optional<Quiz> findByName(String name);
	
}
