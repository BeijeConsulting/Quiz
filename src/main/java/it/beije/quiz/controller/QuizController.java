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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.model.Storico;
import it.beije.quiz.repository.StoricoRepository;


@Controller
@SessionScope
public class QuizController {
	
	private List<Domanda> domande;
	private int tot;
	private LocalTime time = null;
	
	@Autowired
	private StoricoRepository storicoRepository;


	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		System.out.println("Home Page Requested, locale = " + locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);
//
//		return "home";
//	}

//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String user(@Validated User user, Model model) {
//		System.out.println("User Page Requested");
//		model.addAttribute("userName", user.getUserName());
//		return "user";
//	}
	
	/*
	 * salva la scelta del set di domande e rimanda all'index
	 * caricando la pagina iniziale
	 */
	
	@RequestMapping(value="/sceltaset", method= RequestMethod.POST)
	public String iniziale(Model model, @RequestParam String setDomande) {
//		StringBuilder builder = new StringBuilder("C:\\Users\\Padawan10\\git\\Quiz\\domande\\");
		StringBuilder builder = new StringBuilder("C:\\Users\\Padawan04\\git\\Quiz\\domande\\");
		builder.append(setDomande).append(".xml");
		if (domande == null) {
			domande = Utils.readFileDomande(builder.toString());
			tot = domande.size();
		}
		
		model.addAttribute("totDomande", tot);
		
		return "index";
	}
	
	/*
	 * rimanda alla pagina iniziale con la scelta del set di domande
	 */
	@RequestMapping(value = "/sceltaset", method = RequestMethod.GET)
	public String init(Model model) {
		
		return "sceltaset";
	}
	
	/*
	 * setta il timer ad ogni nuova domanda, partendo dal momento in cui si chiama il metodo get
	 * della prima domanda
	 */
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
	private String caricaDomanda(Model model, int index) {
		if (index < tot) {
			Domanda d = domande.get(index);
			String risposta = d.getRispostaUtente();
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
	
	/*
	 * metodo che fa partire il timer e carica la prima domanda del set domande
	 */
	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index) {
		
		setTimer(model);
		
		return caricaDomanda(model, index);
	}
	
	/*
	 * metodo chiamato dopo aver risposto ad una domanda;
	 * carica le risposte dell'utente e va alla domanda successiva
	 */
	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
	public String risposta(Model model, HttpServletRequest request,
			@RequestParam("index") int index) {

		Enumeration<String> enums = request.getParameterNames();
		StringBuilder builder = new StringBuilder();
		while (enums.hasMoreElements()) {
			String name = enums.nextElement();
			//System.out.println(name + " : " + request.getParameter(name));
			if (name.startsWith("rspt_")) {
				builder.append(request.getParameter(name));
			}
		}
		domande.get(index).setRispostaUtente(builder.toString());
		
		setTimer(model);
		
		return caricaDomanda(model, ++index);
	}

	/*
	 * crea il body del riepilogo delle risposte
	 * controllando se siano corrette o meno
	 */
	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
	public String risultati(Model model, HttpServletRequest request) {
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
		Utente utente = (Utente)session.getAttribute("utente");
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
		
		response.setContentType("application/json");
		response.getWriter().append(domanda.toJson());
	}

}
