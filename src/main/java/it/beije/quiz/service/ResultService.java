package it.beije.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Result;
import it.beije.quiz.repository.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	public List<Result> findByUserId(Integer id){
		
		List<Result> results = resultRepository.findByUserId(id);
				
		return results;
		
	}

}
