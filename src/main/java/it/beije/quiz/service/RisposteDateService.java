package it.beije.quiz.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.repository.RisposteDateRepository;

@Service
public class RisposteDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private RisposteDateRepository risposteDateRepository;
    
    
	public List<RisposteDate> risposteUtenteTutte(Integer id_utente) {
		return risposteDateRepository.findByIdUtente(id_utente);
	}
	
	public List<RisposteDate> risposteEsame(Integer id_esame) {
		return risposteDateRepository.findByIdEsame(id_esame);
	}
	
	public RisposteDate rispostaDomanda(Integer id_domanda) {
		Optional<RisposteDate> risposta = risposteDateRepository.findByIdDomanda(id_domanda);
		return risposta.orElse(null);
	}
	
	public RisposteDate rispostaDomanda(Integer idEsame, Integer idDomanda) {
		Optional<RisposteDate> risposta = risposteDateRepository.findByIdEsameAndIdDomanda(idEsame, idDomanda);
		return risposta.orElse(null);
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
	
	@Transactional
	public RisposteDate modifyRispostaUtente(Integer id, String risposte) {
		Optional<RisposteDate> rispostaData = risposteDateRepository.findById(id);
		if(rispostaData.get() == null) {
			return null;
		}

		rispostaData.get().setRisposta(risposte);
		return risposteDateRepository.saveAndFlush(rispostaData.get());
	}
}
