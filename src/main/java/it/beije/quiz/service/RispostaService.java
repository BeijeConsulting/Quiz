package it.beije.quiz.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.repository.RispostaRepository;

@Service
public class RispostaService {
	
	@Autowired
	RispostaRepository rispostaRepository;
	
	@Transactional
	public void insert(Risposta risposta) {
		rispostaRepository.save(risposta);
	}
	
	public List<Risposta> findByBookAndChapterAndQuestion(String book, int chapter, int question) {
		List<Risposta> risposteLibro = rispostaRepository.findByBookAndChapter(book, chapter);
		List<Risposta> risposte = new ArrayList<Risposta>();
		for(Risposta risposta: risposteLibro) {
			if(risposta.getIdDomanda() == question) {
				risposte.add(risposta);
			}
		}
		return risposte;
	}
}