package it.beije.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.BeijeClass;

@Repository
public interface BeijeClassRepository extends JpaRepository<BeijeClass, Integer> {

}
