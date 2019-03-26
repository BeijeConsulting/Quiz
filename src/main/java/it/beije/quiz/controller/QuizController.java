package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.DButils;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;

@Controller
@SessionScope
public class QuizController {
	
	private List<Domanda> domande;
	private int tot;
	private LocalTime time = null;
	private boolean auth = false;
	
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String sub(Model model) {
		
		return "subscribe";
	}
	
	@RequestMapping(value = "/sub", method = RequestMethod.POST)
	public String subscrive(Model model, HttpServletRequest request) {
		
		String path = null;
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String passwordControl = request.getParameter("password2");
		
		auth = DButils.findUser(user);
		if(auth) {
			path = "exist";
		}
		else {
			if (password.equals(passwordControl)) {
				DButils.addUser(user, password);
				path = "login";
			}
			else {
				path = "errorSub";
			}
		}
			
		return path;
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String start(Model model, HttpServletRequest request) {
		
		String path = null;
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		auth = DButils.findUser(user, password);
		if(auth) {
			path = "index";
			if (domande == null) {
				domande = Utils.readFileDomande("C:\\temp\\domande.xml");
				tot = domande.size();
				model.addAttribute("totDomande", tot);
			}
		}
		else {
			path = "error";
		}
			
		return path;
	}
	
	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index) {
		
		setTimer(model);
		
		return caricaDomanda(model, index);
	}
	
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

	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
	public String risultati(Model model) {
		//ELABORAZIONE RISPOSTE
		StringBuilder builder = new StringBuilder();
		for (Domanda d : domande) {
			boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
			
			builder.append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
			if (corretta) {
				builder.append("ESATTO!!! :)<br>");
			} else {
				builder.append("La risposta esatta era " +  d.getRispostaEsatta() + " :(<br>");
			}
			
			builder.append("<br><br>");
		}
		
		model.addAttribute("body", builder.toString());
		
		return "risultati";
	}
}
