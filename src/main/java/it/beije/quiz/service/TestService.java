package it.beije.quiz.service;

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

	public Test createTest(String name, int user) {
		Test t = new Test();
		t.setName(name);
		t.setDate(LocalDate.now().toString());
		t.setUser(user);
		return testRepo.saveAndFlush(t);
	}

	public List<Test> getByUser(Integer user) {
		
		return testRepo.findByUser(user);
	}

}
