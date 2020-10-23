package it.beije.quiz.jpa;

//import java.util.HashMap;
//import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPDBEntityManagerFactory {
	private JPDBEntityManagerFactory() {}
	private static EntityManagerFactory factory;
	public static EntityManager createEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("Quiz");
		}
		return factory.createEntityManager();
	}
}
