package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Storico;

@Repository
public interface StoricoRepository  extends JpaRepository<Storico, Integer> {

	List<Storico> findByIdUtente(Integer utente);
}
