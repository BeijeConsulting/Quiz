package it.beije.quiz.service.old;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Test;
import it.beije.quiz.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepo;

	public Integer saveQuiz(Test test) {
		test.setDate(LocalDate.now().toString());
		testRepo.saveAndFlush(test);
		return test.getId();
	}

	public List<Test> getQuizByUserId(Integer id_user) {
		return testRepo.findByUserId(id_user);
	}

	public Test getEsameById(Integer id_esame){
		return testRepo.findById(id_esame).orElse(null);
	}

	public Test getEsameByNomeQuiz(String nomeQuiz){
		return testRepo.findByName(nomeQuiz).orElse(null);
	}

	public Integer countCorrectQuizByUser(Integer user_id){
		return testRepo.countByUserIdAndResultIsTrue(user_id);
	}

	public Integer countQuizByUser(Integer user_id){
		return testRepo.countByUserId(user_id);
	}
}
