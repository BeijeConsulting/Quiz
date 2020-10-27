package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.quiz.entity.QuestionAnswer;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Integer> {

}
