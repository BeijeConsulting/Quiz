package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{

}
