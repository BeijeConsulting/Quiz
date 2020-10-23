package it.beije.quiz.service;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======



import java.util.List;

>>>>>>> branch 'quizKirolosmater' of https://github.com/BeijeConsulting/Quiz
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
<<<<<<< HEAD
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
=======
	
	public List<Risposta> findByBookAndChapterAndQuestion(String book, int chapter, int question) {
		List<Risposta> risposte = rispostaRepository.findByBookAndChapterAndQuestion(book, chapter, question);
		return risposte;
	}
}
>>>>>>> branch 'quizKirolosmater' of https://github.com/BeijeConsulting/Quiz
