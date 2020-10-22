package it.beije.quiz.repository;

import it.beije.quiz.model.RisposteDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RispostaDataRepository extends JpaRepository<RisposteDate, Long> {
}
