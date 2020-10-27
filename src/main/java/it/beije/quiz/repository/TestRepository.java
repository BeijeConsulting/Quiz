package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
	List<Test> findByUser(Integer id_user);
}
