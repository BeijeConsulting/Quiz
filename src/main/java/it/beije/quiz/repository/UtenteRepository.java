package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
}
