package it.beije.quiz.service;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.repository.DomandaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomandaService {
    @Autowired
    private DomandaRepository domandaRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Domanda save(Domanda d){
        return domandaRepository.saveAndFlush(d);
    }

    public Domanda getByID(Integer id){
        return domandaRepository.findById(id).orElse(null);
    }

    public List<Domanda> getDomandeByBookAndChapter(List<Integer> bookId, List<Integer> chapter){
        System.out.println("metodo nel service per avere le domande");
        List<Domanda> domande = new ArrayList<>();
        for (int i = 0; i < bookId.size(); i++){
            domande.addAll(domandaRepository.findByBookIdAndChapter(bookId.get(i), chapter.get(i)));
        }
        System.out.println("dimensione lista: " + domande.size());
        return domande;
    }

    public Integer countDomandeByBookAndChapter(List<Integer> bookId, List<Integer> chapter){
        return domandaRepository.countByBookIdInAndChapterIn(bookId, chapter);
    }

    public Integer countDomandeSimple(Integer bookId, Integer chapter){
        return domandaRepository.countByBookIdAndChapter(bookId, chapter);
    }
}
