package it.beije.quiz.service;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.repository.DomandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomandaService {
    @Autowired
    private DomandaRepository domandaRepository;

    public Domanda save(Domanda d){
        return domandaRepository.saveAndFlush(d);
    }

    public Domanda getByID(Long id){
        return domandaRepository.findById(id).orElse(null);
    }
}
