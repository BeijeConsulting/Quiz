package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
