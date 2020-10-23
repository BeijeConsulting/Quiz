package it.beije.quiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.model.RisposteDate;

@Repository
public interface RisposteDateRepository extends JpaRepository<RisposteDate, Integer> {

	 	//tutte le risposte date dall'utente:
	List<RisposteDate> findByIdUtente(Integer idUtente);
	
	 	//tutte le risposte date dall'utente in un determinato esame:
	List<RisposteDate> findByIdEsame(Integer idEsame);
	
	 	//la singola risposta dell'utente alla singola domanda:
	Optional<RisposteDate> findByIdDomanda(Integer idDomanda);

	
}