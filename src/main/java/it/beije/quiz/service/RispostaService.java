package it.beije.quiz.service;

import it.beije.quiz.model.Risposta;
import it.beije.quiz.repository.RispostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RispostaService {
    @Autowired
    private RispostaRepository rispostaRepository;

    public Risposta save(Risposta r){
        return rispostaRepository.saveAndFlush(r);
    }
}
