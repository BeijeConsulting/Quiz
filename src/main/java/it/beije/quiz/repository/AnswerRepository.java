package it.beije.quiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	List<Answer> findByTest(Integer test_id);

	List<Answer> findByTestAndCorrect(int test, boolean b);
	
	List<Answer> findByQuizId(Integer quizId);
	
	Optional<Answer> findByQuizIdAndQuestionId(Integer quizId, Integer questionId);

	//it.beije.quiz.entity.Answer @ Integer quiz -> quizId
	//it.beije.quiz.entity.Answer @ Integer question -> questionId
	//it.beije.quiz.entity.Answer @ String answer | testo risposta utente
}
