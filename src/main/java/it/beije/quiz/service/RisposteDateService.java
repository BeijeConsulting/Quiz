package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.repository.RisposteDateRepository;

@Service
public class RisposteDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private RisposteDateRepository risposteDateRepository;
    
    
	public List<RisposteDate> risposteUtenteTutte(Integer id_utente) {
		List<RisposteDate> risposte = risposteDateRepository.findByIdUtente(id_utente);
		return risposte;
	}
	
	public List<RisposteDate> risposteEsame(Integer id_esame) {
		List<RisposteDate> risposte = risposteDateRepository.findByIdEsame(id_esame);
		return risposte;
	}
	
	public RisposteDate rispostaDomanda(Long id_domanda) {
		Optional<RisposteDate> risposta = risposteDateRepository.findByIdDomanda(id_domanda);
		return risposta.isPresent() ? risposta.get() : null;
	}
	
	//@Transactional
	public void insert(RisposteDate rispostaData) {
		if (rispostaData == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		if (!"".equals(rispostaData.getIdUtente().toString()) ||
				!"".equals(rispostaData.getIdDomanda().toString()) ||
				!"".equals(rispostaData.getIdEsame().toString()) ||
				!"".equals(rispostaData.getRisposta()) ) {
	
			risposteDateRepository.save(rispostaData);
			log.info("risposta data inserita!");
			
		} else throw new IllegalArgumentException("dati libro non presenti");
	}
}
