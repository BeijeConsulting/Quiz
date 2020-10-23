package it.beije.quiz.repository;

import it.beije.quiz.model.RisposteDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RispostaDataRepository extends JpaRepository<RisposteDate, Integer> {
	List<RisposteDate> findByIdEsame(Integer idEsame);

	Integer countByIdEsame(Integer idEsame);
}
