package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.quiz.entity.Select;

public interface SelectRepository extends JpaRepository<Select, Integer> {

}