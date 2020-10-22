package it.beije.quiz.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.quiz.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	List<User> findByNickname(String nickname);
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email, String password);
	
}