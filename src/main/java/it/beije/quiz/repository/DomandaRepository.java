package it.beije.quiz.repository;

import it.beije.quiz.model.Domanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, Long> {
}
