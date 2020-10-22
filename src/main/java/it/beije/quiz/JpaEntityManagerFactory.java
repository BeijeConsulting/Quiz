package it.beije.quiz;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JpaEntityManagerFactory {

	private JpaEntityManagerFactory() {}

	private static Map<String, EntityManagerFactory> factoryMap;
	private final static String QUIZ = "Quiz";

	public static EntityManager createEntityManager(String persistenceUnitName) {
		return JpaEntityManagerFactory.getInstance().createEntityManager();
	}


	@Bean(name = "entityManagerFactory")
	public static synchronized EntityManagerFactory getInstance() {
		if (factoryMap == null) {
			factoryMap = new HashMap<String, EntityManagerFactory>();
		}

		if (!factoryMap.containsKey(QUIZ)) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(QUIZ);
			factoryMap.put(QUIZ, factory);
		}
		return factoryMap.get(QUIZ);
	}
}
