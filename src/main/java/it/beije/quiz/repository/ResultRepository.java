package it.beije.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{

	List<Result> findByUserId(Integer id);
}
