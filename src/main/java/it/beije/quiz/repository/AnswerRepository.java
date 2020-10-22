package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	List<Answer> findByTest(Integer test_id);

}
