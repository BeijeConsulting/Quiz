package it.beije.quiz.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.RisposteDateService;

@RestController
@RequestMapping("/rest")
public class RisposteDateRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private RisposteDateService risposteDateService;
    
    
  //SELECT ALL ID_UTENTE
  	@RequestMapping(value = "/risposte_date_utente/{id_utente}", method = RequestMethod.GET)
  	public List<RisposteDate> getRisposteUtente(@PathVariable Integer id_utente) {
  		
  		List<RisposteDate> risposte = risposteDateService.risposteUtenteTutte(id_utente);
  		
		log.info("risposte date dall'utente " + id_utente + " : " + risposte);
  		
  		return risposte;		
  	}
  	
  	//SELECT ALL ID_ESAME 
  	@RequestMapping(value = "/risposte_date_utente_esame/{id_esame}", method = RequestMethod.GET)
  	public List<RisposteDate> getRisposteEsame(@PathVariable Integer id_esame) {
  		
  		List<RisposteDate> risposte = risposteDateService.risposteEsame(id_esame);
  		
		log.info("risposte date dall'utente nell'esame " + id_esame + " : " + risposte);
  		
  		return risposte;		
  	}
  	
  	//SELECT ID_DOMANDA
  	@RequestMapping(value = "/risposta_alla_domanda/{id_domanda}", method = RequestMethod.GET)
  	public RisposteDate getRisposta(@PathVariable Integer id_domanda) {
  		
  		RisposteDate risposta = risposteDateService.rispostaDomanda(id_domanda);
  		
		log.info("risposte alla domanda" + id_domanda + " : " + risposta);

  		return risposta;
  	}
  	

  	//INSERT
//  	@RequestMapping(value = "/risposta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  	@PostMapping("/risposta")
  	public RisposteDate insertLibro(@RequestBody RisposteDate risposta) {

		log.info("ricevo dati risposta" + risposta);
  		
		risposteDateService.insert(risposta);
  		
  		return risposta;
  	}
}
