package it.beije.quiz.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

public class JPAUtils {
	public static void insertDomanda(String book, Integer chapter, Integer question, String testo, String type, String spiegazione) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Domanda domanda = new Domanda(book, chapter, question, testo, type, spiegazione);
		entityManager.persist(domanda);
		transaction.commit();
		entityManager.close();
	}
	public static void insertRisposta(Long idDomanda, String lettera, String risposta, boolean corretto, String book, Integer chapter) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Risposta answer = new Risposta(idDomanda, lettera, risposta, corretto, book, chapter);
		entityManager.persist(answer);
		transaction.commit();
		entityManager.close();
	}
}