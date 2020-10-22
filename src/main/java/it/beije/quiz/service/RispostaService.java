package it.beije.quiz.service;

import it.beije.quiz.model.Risposta;
import it.beije.quiz.repository.RispostaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RispostaService {
    @Autowired
    private RispostaRepository rispostaRepository;
    
    public List<Risposta> findByIdDomanda(Long idDomanda) {
    	return rispostaRepository.findByIdDomanda(idDomanda);
    }
    
    public Risposta save(Risposta r){
        return rispostaRepository.saveAndFlush(r);
    }
}
