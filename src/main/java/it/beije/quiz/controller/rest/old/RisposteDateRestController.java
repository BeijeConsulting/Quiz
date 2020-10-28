//package it.beije.quiz.controller.rest.old;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.quiz.entity.Answer;
//import it.beije.quiz.service.old.AnswerService;
//
//@RestController
//@RequestMapping("/rest")
//public class RisposteDateRestController {
//
//	private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private AnswerService answerService;
//
//
//    //SELECT ALL ID_UTENTE
//    //TEORICAMENTE RITORNA TUTTE LE RISPOSTE DADE DA UTENTE X IN ASSOLUTO, FORSE NON PIU SUPPORTATO
//
////  	@RequestMapping(value = "/risposte_date_utente/{id_utente}", method = RequestMethod.GET)
////  	public List<Answer> getRisposteUtente(@PathVariable Integer id_utente) {
////
////  		List<Answer> risposte = AnswerService.risposteUtenteTutte(id_utente);
////
////		log.info("risposte date dall'utente " + id_utente + " : " + risposte);
////
////  		return risposte;
////  	}
//
//  	//SELECT ALL ID_ESAME
//    //SELECT ALL ANSWERS OF GIVEN EXAM (QuizId)
//  	@RequestMapping(value = "/risposte_date_utente_esame/{id_esame}", method = RequestMethod.GET)
//  	public List<Answer> getRisposteEsame(@PathVariable Integer quizId) {
//
//  		List<Answer> risposte = answerService.selectAllByQuizId(quizId);
//		log.info("risposte date dall'utente nell'esame " + quizId + " : " + risposte);
//  		return risposte;
//  	}
//
//  	//SELECT ID_DOMANDA
//  	//DATA UNA DOMANDA(IL SUO ID) RITORNA LA SUA RISPOSTA --- NON SERVE PIU VISTA NUOVAA IMPLEMENTAZIONE DI QUESTION
//  	//SUL DB CHE CONTIENE GIA' LE SUE RISPOSTE
//
////  	@RequestMapping(value = "/risposta_alla_domanda/{id_domanda}", method = RequestMethod.GET)
////  	public Answer getRisposta(@PathVariable Integer questionId) {
////
////  		Answer risposta = answerService.selectAnswerByQuestionID(questionId);
////
////		log.info("risposte alla domanda" + questionId + " : " + risposta);
////
////  		return risposta;
////  	}
//
//  	@RequestMapping(value="/risposta_data/{idEsame}/{idDomanda}", method = RequestMethod.GET)
//  	public Answer getRispostaData(@PathVariable Integer idQuiz, @PathVariable Integer idQuestion) {
//  		Answer risposta = answerService.selectByQuizIdAndQuestionId(idQuiz, idQuestion);
//  		log.info("risposte alla domanda" + idQuestion + " : " + risposta);
//  		return risposta;
//  	}
//
//  	@RequestMapping(value="/risposta_data/{idEsame}/{idDomanda}", method = RequestMethod.PUT)
//  	public Answer putRispostaData(@RequestBody Answer answer, @PathVariable Integer idEsame, @PathVariable Integer idDomanda) {
//  		Answer returnAnswer = answerService.updateAnswer(answer.getId(), answer.getAnswer());
//  			log.debug("Risposta modificata");
//  			return returnAnswer;
//  	}
//
//  	//INSERT
//  	@PostMapping("/risposta")
//  	public Answer insertLibro(@RequestBody Answer answer) {
//
//		log.info("ricevo dati risposta" + answer);
//
//		answerService.insert(answer);
//
//  		return answer;
//  	}
//}
