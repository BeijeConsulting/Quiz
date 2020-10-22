package it.beije.quiz.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Book;
import it.beije.quiz.entity.Chapter;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Test;
import it.beije.quiz.entity.User;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.model.Storico;
import it.beije.quiz.repository.StoricoRepository;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.BookService;
import it.beije.quiz.service.ChapterService;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.TestService;


@Controller
@SessionScope
public class QuizController {
	
	private int tot;
	private LocalTime time = null;
	@Autowired
	private BookService bookService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private TestService testService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	


	@RequestMapping(value="/gen_test", method= RequestMethod.POST )
	public String genTest(HttpServletRequest request, HttpSession session) {
		String sel = request.getParameter("scelta");
		String set = request.getParameter("setDomande");
		String name = request.getParameter("name");
		int usr = ((User) session.getAttribute("user")).getId();
		String bookTitle = null;
		if(sel.equals("guide")) {
			bookTitle = "oca_certification_guide_manning";
		}else{
			bookTitle = "oca_manual";
		}
		Book b = bookService.getBook(bookTitle);
		Chapter c = chapterService.getChapter(set);
		List<Question> questions = questionService.getChapterQuestions(c.getId());
		Test t = testService.createTest(name, usr);
		List<Answer> answers = answerService.createAnswers(questions, t.getId());
		questionService.setAnswers(answers);
		questionService.setQuestions(questions);
		return "quiz_view"; //da cambiare con quello vero
	}
	/*
	 * metodo che fa partire il timer e carica la prima domanda del set domande
	 */
	@RequestMapping(value = "/question/{index}", method = RequestMethod.GET)
	public String question(Model model, @PathVariable("index") int index) {
		setTimer(model);
		return loadQuestion(model, index);
	}
	
	/*
	 * metodo chiamato dopo aver risposto ad una domanda;
	 * carica le risposte dell'utente e va alla domanda successiva
	 */
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public String answer(Model model, Answer answer) {
		int index = answer.getIndex();
		
		setTimer(model);
		
		return loadQuestion(model, ++index);
	}

	/*
	 * crea il body del riepilogo delle risposte
	 * controllando se siano corrette o meno
	 */
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int counter = 0;
		//ELABORAZIONE RISPOSTE
		StringBuilder builder = new StringBuilder();
		for (Domanda d : domande) {
			boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
			
			builder.append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
			if (corretta) {
				builder.append("ESATTO!!! :)<br>");
				counter++;
			} else {
				builder.append("La risposta esatta era " +  d.getRispostaEsatta() + " :(<br>");
			}
			
			builder.append("<br><br>");
		}
		
		model.addAttribute("body", builder.toString());
		double score = counter * 100.0 / domande.size();
		boolean esito = score >= 65;
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		long hours = diff.getSeconds()/3600;
		long minutes = diff.getSeconds()/60 - hours* 60;
		long seconds =  diff.getSeconds() - hours * 3600 - minutes * 60;
		Storico storico = new Storico();
		User utente = (User)session.getAttribute("utente");
		storico.setIdutente(utente.getId());
		storico.setDurata(hours+"."+minutes+"."+seconds);
		if(esito) storico.setEsito("pass");
		else storico.setEsito("fail");
		storico.setPunteggio(counter+"/"+domande.size());
		storico.setScore(score);
		storico.setData(LocalDate.now());
		storicoRepository.saveAndFlush(storico);
		return "risultati";
	}
	
	@GetMapping(value="/home")
	public String home() {
		log.info("returning to homepage");
		return "home";
	}
	
	/////// REST
	
	@RequestMapping(value = "/api/domanda", method = RequestMethod.GET)
	public void testrest(Model model, HttpServletResponse response) throws IOException {
		System.out.println("entra??");
		List<Risposta> risposte = new ArrayList<Risposta>();
		Risposta r = new Risposta();
		r.setValue("A");
		r.setText("risposta prova");
		risposte.add(r);
		Domanda domanda = new Domanda(1, "book", 2, 3, "questa è una prova", "checkbox", risposte, "A", "nessuna");
	}

	private void setTimer(Model model) {
		if (time == null) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		int tot = domande.size();
		int secondi = 2 * 60 * tot;
		long hours = (secondi - diff.getSeconds())/3600;
		long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;

		
		model.addAttribute("totDomande", tot);
		model.addAttribute("ore", hours);
		model.addAttribute("minuti", minutes);
		model.addAttribute("secondi", seconds);
	}

	/*
	 * carica la domanda con l'index dato dal metodo post o get.
	 * Ho aggiunto la lettera corrispondente alla risposta, su domanda.jsp
	 * e modificato il link Succ. (di domanda.jsp) perchè chiamava erroneamente tot al posto di totDomande
	 */
	private String loadQuestion(Model model, int index) {
		if (index < tot) {
			Question q = questions.get(index);
			String answer = q.getRispostaUtente();
			//System.out.println("risposta : " + risposta);
			if (risposta == null) {
				risposta = "";
			}
			model.addAttribute("index", index);
			model.addAttribute("testoDomanda",Utils.formattaTesto(d.getTesto()));
			model.addAttribute("rispUtente", risposta);
			model.addAttribute("answerType", d.getAnswerType());
			model.addAttribute("risposte",d.getRisposte());
			
			return "domanda";
		}
		else {
			return "riepilogo";
		}
	}
}
