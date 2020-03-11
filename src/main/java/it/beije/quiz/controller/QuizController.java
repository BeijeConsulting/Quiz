package it.beije.quiz.controller;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.xml.sax.SAXException;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.service.QuizService;

@Controller
@SessionScope
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	private int totale = 0;
	private LocalTime time = null;
	private static boolean isNew = false;
	private List<Libro> libri;
	private ArrayList<Domanda> domandetot = new ArrayList<Domanda>();
	private final String MAIN_PATH = "C:\\Users\\Padawan11\\git\\Quiz\\domande\\";

	@RequestMapping(value = "/", method = RequestMethod.GET) // index è una parola chiave prende quello che indichi nel
	// name="prefix" value="/WEB-INF/views/"
	public String index(HttpServletRequest request, Model model) {

		return "domandemanager";
	}

	@RequestMapping(value = "/totaledomande", method = RequestMethod.GET)
	public String init(Model model, HttpServletRequest request, HttpSession session)
			throws ParserConfigurationException, SAXException, IOException {


		libri = quizService.caricaLibri(new File(MAIN_PATH + "index.xml"));

		if (!domandetot.isEmpty()) 
			domandetot.clear();
		for (int i = 0; i < libri.size(); i++) {

			File folder = new File(MAIN_PATH + libri.get(i).getNameDir());

			for (final File fileEntry : folder.listFiles()) {
				// domande1.addAll(quizService.readFileDomande(folder + "\\" + fileEntry.getName()));
				if (request.getParameter("libro" + (i + 1)) != null) {
					domandetot.addAll(quizService.readFileDomande(folder + "\\" + fileEntry.getName()));

				}

			}

			libri.get(i).setDomande(domandetot);
		}

		totale = domandetot.size();
		model.addAttribute("totDomande", totale);
		// domande1.clear();

		return "totaledomande";
	}

	private void setTimer(Model model) {
		if (time == null) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);

		int secondi = 2 * 60 * totale;
		long hours = (secondi - diff.getSeconds()) / 3600;
		long minutes = (secondi - diff.getSeconds()) / 60 - hours * 60;
		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;

		model.addAttribute("totDomande", totale);
		model.addAttribute("ore", hours);
		model.addAttribute("minuti", minutes);
		model.addAttribute("secondi", seconds);
	}

	private String caricaDomanda(Model model, int index) {

		if (index < totale) {

			Domanda d = domandetot.get(index);
			String risposta = d.getRispostaUtente();
			// System.out.println("risposta : " + risposta);
			if (risposta == null) {
				risposta = "";
			}
			// System.out.println(i.getDomande().get(index));
			model.addAttribute("index", index);
			model.addAttribute("testoDomanda", quizService.formattaTesto(d.getTesto()));
			model.addAttribute("rispUtente", risposta);
			model.addAttribute("answerType", d.getAnswerType());
			model.addAttribute("risposte", d.getRisposte());
			// portare a false il valore di libro

			return "domanda";
		} else {

			return "riepilogo";
		}

	}

	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index) {

		setTimer(model);

		return caricaDomanda(model, index);
	}

	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
	public String risposta(Model model, HttpServletRequest request, @RequestParam("index") int index) {

		Enumeration<String> enums = request.getParameterNames();
		StringBuilder builder = new StringBuilder();
		while (enums.hasMoreElements()) {
			String name = enums.nextElement();
			// System.out.println(name + " : " + request.getParameter(name));
			if (name.startsWith("rspt_")) {
				builder.append(request.getParameter(name));
			}
		}
		domandetot.get(index).setRispostaUtente(builder.toString());

		setTimer(model);

		return caricaDomanda(model, ++index);
	}

	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
	public String risultati(Model model) {
		// ELABORAZIONE RISPOSTE
		StringBuilder builder = new StringBuilder();
		for (Domanda d : domandetot) {
			boolean corretta = quizService.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());

			builder.append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
			if (corretta) {
				builder.append("ESATTO!!! :)<br>");
			} else {
				builder.append("La risposta esatta era " + d.getRispostaEsatta() + " :(<br>");
			}

			builder.append("<br><br>");
		}

		model.addAttribute("body", builder.toString());

		return "risultati";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String scelta() {


		return "scelta";
	}

	@RequestMapping(value = "/newlibro", method = RequestMethod.GET)
	public String newLibro() {

		isNew=true;

		return "newlibro";
	}

	@RequestMapping(value = "/newdomanda", method = RequestMethod.GET)
	public String creaDomanda(Model model) {

		model.addAttribute("isNew", isNew);

		return "creadomanda";
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
		Domanda domanda = new Domanda("1", "book", "2", " 3", "questa è una prova", "checkbox", risposte, "A",
				"nessuna");

		response.setContentType("application/json");
		response.getWriter().append(domanda.toJson());
	}

}
