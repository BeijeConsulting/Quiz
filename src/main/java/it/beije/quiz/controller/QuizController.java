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
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.xml.sax.SAXException;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;


@Controller
@SessionScope
public class QuizController {

	private List<Domanda> domande = new ArrayList<Domanda>();
	private int tot;
	private LocalTime time = null;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) throws ParserConfigurationException, SAXException, IOException {

		return "index";
	}
	

//	@RequestMapping(value="/confermaselezione", method = RequestMethod.POST)
//	public String confermaDomande(Model model) {
//		model.addAttribute("totDomande", model.getAttribute("totDomande"));
//		return "confermaselezione";
//	}
	
	@RequestMapping(value = "/getDomande")
	public String prova() {
		return "getDomande";
	}

	@RequestMapping(value="/confermaselezione", method = RequestMethod.POST)
	public String lettura(Model model, HttpServletRequest request) throws ParserConfigurationException, SAXException, IOException {
		tot = 0;
		domande.clear();
		String baseDirectory = "C:\\Users\\Padawan04\\git\\Quiz\\domande\\";
		List<Libro> libri = Utils.getLibri();
		System.out.println(libri.size());
		for(int l = 1; l <= libri.size(); l++) {
			String directory = "";
			System.out.println(request.getParameter("libro" + l));
			if (request.getParameter("libro" + l) != null) {
			    directory = request.getParameter("libro" + l);
				System.out.println(directory);
			} else {
				continue;
			}
			


//			for(Libro lib : libri) {
				if(libri.get(l-1).getDir().equals(directory)) {
					String dir = baseDirectory + libri.get(l-1).getDir();
					//System.out.println(dir);
					File f = new File(dir);
					for(File file : f.listFiles()) {
						if(!file.isDirectory()) {
							domande.addAll(Utils.readFileDomande(file.getAbsolutePath(), directory));
						}
					}
					libri.get(l-1).setLista(domande);
					tot = domande.size(); //libri.get(l-1).getLista().size();
					//domande.clear();
				}
//			}
//			System.out.println("libri : " + libri.size());

			//			}
		}

		model.addAttribute("totDomande", tot);
		
//		tot = 0;
		
		System.out.println("SIZE: " + tot);
		System.out.println("SIZE domande: " + domande.size());
		

		return "domanda";
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

	private String caricaDomanda(Model model, int index) {
		System.out.println("tot: " + tot + "index: " + index); 
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

	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
	public String domanda(Model model, @PathVariable("index") int index) {

		setTimer(model);

		return caricaDomanda(model, index);
	}
	
	@RequestMapping(value = "/insertdomanda", method = RequestMethod.GET)
	public String domanda1(Model model) {
		return "insertdomanda";
	}
	
	@RequestMapping(value = "/addnewdomanda", method = RequestMethod.POST)
	public String writeNewQuestion(HttpServletRequest request) throws Exception {
		// popolare bean Domanda
		Domanda domanda;
		String id = request.getParameter("numDomanda");
		String book = request.getParameter("bookName");
		String chapter =  request.getParameter("numCapitolo");
		String question =  request.getParameter("numDomanda");
		String testo =  request.getParameter("testoDomanda");
		String answerType =  request.getParameter("typeQuestion");
		
		List<Risposta> listaRisposte = new ArrayList<Risposta>();
		int i = 1;
		while(request.getParameter("risposta" + i) != null) {
			Risposta r = new Risposta();
			r.setValue(request.getParameter("valueRisposta" + i));
			r.setText(request.getParameter("risposta" + i));
			listaRisposte.add(r);
			i++;
		}
		
		String rispostaEsatta =  request.getParameter("risposteEsatte");
		String spiegazione =  request.getParameter("spiegazione");
		
		domanda = new Domanda(id, book, chapter, question, testo, answerType, listaRisposte, rispostaEsatta, spiegazione);
		
		List<Libro> libri = Utils.getLibri();
		String dirLibro = "";
		for(Libro l : libri) {
			if(l.getTitle().equals(book)) {
				dirLibro = l.getDir();
				break;
			}
		}
		// scrivere - modificare xml
		Utils.writeDomandeXML(domanda, "C:\\Users\\Padawan04\\git\\Quiz\\domande\\" + dirLibro + "\\domande_cap" + chapter + ".xml");
		
		return "risultatoinserimento";
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
	



	/////// REST

	@RequestMapping(value = "/api/domanda", method = RequestMethod.GET)
	public void testrest(Model model, HttpServletResponse response) throws IOException {
		System.out.println("entra??");
		List<Risposta> risposte = new ArrayList<Risposta>();
		Risposta r = new Risposta();
		r.setValue("A");
		r.setText("risposta prova");
		risposte.add(r);
		Domanda domanda = new Domanda("1", "book", "2","3", "questa è una prova", "checkbox", risposte, "A", "nessuna");

		response.setContentType("application/json");
		response.getWriter().append(domanda.toJson());
	}

}
