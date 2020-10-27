package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByChapter(Integer chapter_id);
}
