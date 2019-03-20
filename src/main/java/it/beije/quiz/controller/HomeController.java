package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
//import it.beije.quiz.model.User;

@Controller
@SessionScope
public class HomeController {
	
	private List<Domanda> domande = Utils.readFileDomande("C:\\temp\\domande.xml");
	private LocalTime time = null;
	private List<Risposta> scelte = null;

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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		int tot = domande.size();
//		System.out.println(tot);
		
		model.addAttribute("totDomande", tot);
		
		return "index";
	}
	
	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index) {
		
		String ref = "";
		if(index == 0) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		int tot = domande.size();
		int secondi = 2 * 60 * tot;
		long hours = (secondi - diff.getSeconds())/3600;
		long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;
		
		model.addAttribute("index", index);
		model.addAttribute("totDomande", tot);
		model.addAttribute("ore", hours);
		model.addAttribute("minuti", minutes);
		model.addAttribute("secondi", seconds);
		
		if (index < tot) {
			Domanda d = domande.get(index);
			String risposta = d.getRispostaUtente();
			if (risposta == null) {
				risposta = "";
			}
			scelte = d.getRisposte();
//			System.out.println(Utils.formattaTesto(d.getTesto()));
			model.addAttribute("testoDomanda",Utils.formattaTesto(d.getTesto()));
			model.addAttribute("size",scelte.size());
			model.addAttribute("answerType",d.getAnswerType());
			ref = "domanda";
			for(Risposta r : scelte) {
				
			}
		}
		else {
			ref = "endQuestion";
		}
		
		return ref;
	}
	
}
