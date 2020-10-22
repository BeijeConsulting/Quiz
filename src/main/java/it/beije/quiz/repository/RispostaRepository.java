package it.beije.quiz.repository;

import it.beije.quiz.model.Risposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RispostaRepository extends JpaRepository<Risposta, Long> {
}
