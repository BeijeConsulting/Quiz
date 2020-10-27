package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	List<Answer> findByIdTest(Integer test_id);

	List<Answer> findByIdTestAndCorrectIsTrue(Integer id_test);

	Integer countByIdTest(Integer test_id);
}
