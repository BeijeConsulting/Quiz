package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
