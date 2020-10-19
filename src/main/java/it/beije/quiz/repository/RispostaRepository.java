package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Risposta;

@Repository
public interface RispostaRepository extends JpaRepository<Risposta, Long> {
 
}
