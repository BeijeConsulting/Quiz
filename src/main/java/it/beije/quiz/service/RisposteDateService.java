package it.beije.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.repository.RispostaDataRepository;

@Service
public class RisposteDateService {
	
	@Autowired
	private RispostaDataRepository rispostaDataRepository;
	
	public List<RisposteDate> findByIdEsame(Integer idEsame) {
		return rispostaDataRepository.findByIdEsame(idEsame);
	}
}
