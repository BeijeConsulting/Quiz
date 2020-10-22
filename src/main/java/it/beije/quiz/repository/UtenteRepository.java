package it.beije.quiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	Optional<Utente> findByEmailAndPassword(String email, String password);
	Optional<Utente> findByEmail(String email);
	
}
