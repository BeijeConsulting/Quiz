package it.beije.quiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

	Optional<Chapter> getByTitle(String cName);

}
