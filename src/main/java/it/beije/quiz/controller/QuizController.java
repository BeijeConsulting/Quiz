package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
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

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;


@Controller
@SessionScope
public class QuizController {
	
	private List<Domanda> domande=new ArrayList<>();
	private int tot ;
	private LocalTime time = null;
	List<Libro> libri;
	String[] checkboxValues;

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
	public String init(Model model, HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		libri = Utils.readFileLibri();
		for(Libro l : libri)
			System.out.println(l.getIdBook());
		
		if (request.getParameterValues("bookSelection")!=null) {
			checkboxValues = request.getParameterValues("bookSelection");
			
			for(String v : checkboxValues)
				System.out.println(v);
			
			for(Libro l : libri) {
				String idBook = l.getIdBook();
				for(String v : checkboxValues) {
					if(idBook.equals(v)) {
						
						System.out.println(v);
						
						List <Domanda> ciclaDomande = l.caricaQuestions();
						for(Domanda d : ciclaDomande) {
							
							System.out.println(d.getQuestion());
							
							domande.add(d);}
						
					}
				}
			}
		
		domande.size();
		}
				
		model.addAttribute("libri", libri);
		model.addAttribute("totDomande", tot);
		
		return "index";
	}
	
	private void setTimer(Model model) {
		if (time == null) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		
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
	
		//*********************************************************************************
		
		
		if (index < tot) {
			Domanda d = domande.get(index);
			String risposta = d.getRispostaUtente();
			System.out.println("risposta : " + risposta);
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
	
	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index,HttpServletRequest request) {
		System.out.println("Index Page Requested : " + request.getRequestURI());
		
		if (request.getParameterValues("bookSelection")!=null) {
			checkboxValues = request.getParameterValues("bookSelection");
		
			for(String v : checkboxValues) {
				for(Libro l : libri) {
					if(l.getIdBook().equals(v)) 
						domande.addAll(l.caricaQuestions());
				}
			}
			tot = domande.size();
		}
		
		setTimer(model);
		
		
		
		return caricaDomanda(model, index);
	}
	
	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
	public String risposta(Model model, HttpServletRequest request,
			@RequestParam("index") int index) {
		System.out.println("index Page Requested : " + request.getRequestURI());
	        
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
	
//	@RequestMapping(value = "/caricaLibri", method = RequestMethod.POST)
//	public String caricaLibri(Model model,HttpServletRequest request) {
//		String[] libri = request.getParameterValues("bookSelection");
//		
//		for(String l : libri)
//			System.out.println(l);
//		
//		return "index";
//	}
	
	
	/////// REST
//	
//	@RequestMapping(value = "/api/domanda", method = RequestMethod.GET)
//	public void testrest(Model model, HttpServletResponse response) throws IOException {
//		System.out.println("entra??");
//		List<Risposta> risposte = new ArrayList<Risposta>();
//		Risposta r = new Risposta();
//		r.setValue("A");
//		r.setText("risposta prova");
//		risposte.add(r);
//		Domanda domanda = new Domanda(1, "book", 2, 3, "questa è una prova", "checkbox", risposte, "A", "nessuna");
//		
//		response.setContentType("application/json");
//		response.getWriter().append(domanda.toJson());
//	}

}
