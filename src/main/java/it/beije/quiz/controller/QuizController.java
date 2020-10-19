package it.beije.quiz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.quiz.Utils;


//import java.io.IOException;
//import java.time.Duration;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.context.annotation.SessionScope;
//
//import it.beije.quiz.Utils;
//import it.beije.quiz.model.Domanda;
//import it.beije.quiz.model.Risposta;


@Controller
//@SessionScope
public class QuizController {
	
//	private List<Domanda> domande;
//	private int tot;
//	private LocalTime time = null;
	private Utils utils = new Utils();
	
	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}


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
	 * Inizializzazione della pagina, carica le domande da un file se ancora la lista è nulla, controlla quante sono,
	 * lo mette nel model e ritorna la pagina iniziale.
	 * Purtroppo legge solo domande.xml, quindi c'è da impostre manualmente il file da cui legge.
	 */
	@PostMapping(value = "/home")
	public String init(HttpServletRequest request) {
		
		utils.xmlToDatabase(request.getParameter("id"));
//		model.addAttribute("totDomande", tot);
		
		return "index";
	}
	
	/*
	 * All'inizio, se nel controller il time è ancora nullo, allora imposta il tempo attuale: il test è iniziato.
	 * Ogni volta che viene chiamato il metodo, controlla quanto tempo è passato da quando è iniziato il test indicandolo
	 * con il pattern HH:mm:ss
	 */
//	private void setTimer(Model model) {
//		if (time == null) {
//			time = LocalTime.now();
//		}
//		LocalTime now = LocalTime.now();
//		Duration diff = Duration.between(time, now);
//		int tot = domande.size();
//		int secondi = 2 * 60 * tot;
//		long hours = (secondi - diff.getSeconds())/3600;
//		long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
//		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;
//		
//		model.addAttribute("totDomande", tot);
//		model.addAttribute("ore", hours);
//		model.addAttribute("minuti", minutes);
//		model.addAttribute("secondi", seconds);
//	}
	
	/*
	 * Raccoglie un index e trova la domanda dalla lista delle domande caricata.
	 * Mette nel model i vari attributi di quella domanda.
	 * Però se l'index è il tot (ha raggiunto al fine), allora mostra il riepilogo.
	 */
//	private String caricaDomanda(Model model, int index) {
//		if (index < tot) {
//			Domanda d = domande.get(index);
//			String risposta = d.getRispostaUtente();
//			//System.out.println("risposta : " + risposta);
//			if (risposta == null) {
//				risposta = "";
//			}
//			model.addAttribute("index", index);
//			model.addAttribute("testoDomanda",Utils.formattaTesto(d.getTesto()));
//			model.addAttribute("rispUtente", risposta);
//			model.addAttribute("answerType", d.getAnswerType());
//			model.addAttribute("risposte",d.getRisposte());
//			
//			return "domanda";
//		}
//		else {
//			return "riepilogo";
//		}
//	}
	
	/*
	 * Carica la domanda secondo l'index o ritorna il riepilogo. Nel frattempo setta anche il timer.
	 */
//	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
//	public String domanda(Model model, @PathVariable("index") int index) {
//		
//		setTimer(model);
//		
//		return caricaDomanda(model, index);
//	}
//	
	/*
	 * Quando viene data la risposta, viene salvato nella domanda attuale la risposta dell'utente.
	 * Poi setta il timer e passa all'index successivo.
	 */
//	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
//	public String risposta(Model model, HttpServletRequest request,
//			@RequestParam("index") int index) {
//
//		Enumeration<String> enums = request.getParameterNames();
//		StringBuilder builder = new StringBuilder();
//		while (enums.hasMoreElements()) {
//			String name = enums.nextElement();
//			//System.out.println(name + " : " + request.getParameter(name));
//			if (name.startsWith("rspt_")) {
//				builder.append(request.getParameter(name));
//			}
//		}
//		domande.get(index).setRispostaUtente(builder.toString());
//		
//		setTimer(model);
//		
//		return caricaDomanda(model, ++index);
//	}

	/*
	 * Pagina dei risultati, qua vengono controllate se le varie risposte sono corrette,
	 * dando i vari feedback
	 */
//	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
//	public String risultati(Model model) {
//		//ELABORAZIONE RISPOSTE
//		StringBuilder builder = new StringBuilder();
//		for (Domanda d : domande) {
//			boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
//			
//			builder.append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
//			if (corretta) {
//				builder.append("ESATTO!!! :)<br>");
//			} else {
//				builder.append("La risposta esatta era " +  d.getRispostaEsatta() + " :(<br>");
//			}
//			
//			builder.append("<br><br>");
//		}
//		
//		model.addAttribute("body", builder.toString());
//		
//		return "risultati";
//	}
//	
	
	
	/////// REST
	
	/*
	 * Ah boh, sembra un tentativo di fare un servizio rest e utilizza tra l'altro una domanda preimpostata.
	 * Sicuramente è importante il fatto che la risposta è un Json che dovrà essere utilizzato per settare
	 * le varie domande.
	 */
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
//
}
	

