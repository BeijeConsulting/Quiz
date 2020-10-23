package it.beije.quiz.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.quiz.model.Risposta;
@Repository
public interface RispostaRepository extends JpaRepository<Risposta, Long> {
	List<Risposta> findByBookAndChapter(String book, int chapter);
}