package it.beije.quiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.UserAnswer;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer>{

	List<UserAnswer> findByQuizIdAndCorrectIsTrue(Integer quizId);
	List<UserAnswer> findByQuizId(Integer quizId);
	Optional<UserAnswer> findByQuizIdAndQuestionId(Integer quizId, Integer questionId);
	Integer countByQuizId(Integer quizId);
}