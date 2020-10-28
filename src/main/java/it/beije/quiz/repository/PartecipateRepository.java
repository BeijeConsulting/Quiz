package it.beije.quiz.repository;

import it.beije.quiz.entity.Partecipate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartecipateRepository extends JpaRepository<Partecipate, Integer> {
    Optional<Partecipate> findByQuizId(Integer quizId);
    List<Partecipate> findByUserId(Integer userId);
}
