package it.beije.quiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
	List<Test> findByUserId(Integer id_user);
	Optional<Test> findByName(String name);
}
