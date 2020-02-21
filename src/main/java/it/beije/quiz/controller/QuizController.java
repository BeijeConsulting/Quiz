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
import it.beije.quiz.model.Risposta;

@Controller
@SessionScope
public class QuizController {

	private List<Domanda> domande = new ArrayList<Domanda>();
	private int tot;
	private LocalTime time = null;
	private List<Libro> listaLibriInXML = new ArrayList<Libro>();

	@RequestMapping(value = "/caricaDomande", method = RequestMethod.POST)
	public String loadDomande(Model model, HttpServletRequest req) {		
		
		List<File> globalz = new ArrayList<File>();
		
		for(int i = 0; i < listaLibriInXML.size(); i++) {
			String pathDir = req.getParameter("dir" + i);
			globalz.addAll(Utils.selezionaFileDiInteresse(pathDir));
		}		
		
		for(File file : globalz) {			
			domande.addAll(Utils.readFileDomande(file.getPath()));
		}
		tot = domande.size(); 	
		
		return domanda(model, 0);
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {

//		if (domande == null) {
//			domande = Utils.readFileDomande("C:\\temp\\domande_cap1.xml");
//			tot = domande.size();
//		}
		
//		model.addAttribute("numLibri", listaLibriInXML.size());
//		for(int i = 0; i < listaLibriInXML.size(); i++) {
//			model.addAttribute("dirLibro"+i, listaLibriInXML.get(i).getDir());
//			model.addAttribute("titleLibro"+i, listaLibriInXML.get(i).getTitle());
//		}
		listaLibriInXML =  Utils.caricaLibriDaIndexXML("domande/index.xml");
		model.addAttribute("listaLibri", listaLibriInXML);
		model.addAttribute("totDomande", tot);

		return "index";
	}

	
	
	private void setTimer(Model model) {
		if (time == null) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		int tot = domande.size();
		int secondi = 2 * 60 * tot;
		long hours = (secondi - diff.getSeconds()) / 3600;
		long minutes = (secondi - diff.getSeconds()) / 60 - hours * 60;
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
			// System.out.println("risposta : " + risposta);
			if (risposta == null) {
				risposta = "";
			}
			model.addAttribute("index", index);
			model.addAttribute("testoDomanda", Utils.formattaTesto(d.getTesto()));
			model.addAttribute("rispUtente", risposta);
			model.addAttribute("answerType", d.getAnswerType());
			model.addAttribute("risposte", d.getRisposte());

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
		domande.get(index).setRispostaUtente(builder.toString());

		setTimer(model);

		return caricaDomanda(model, ++index);
	}

	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
	public String risultati(Model model) {
		// ELABORAZIONE RISPOSTE
		StringBuilder builder = new StringBuilder();
		for (Domanda d : domande) {
			boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());

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

	
	/****************BRANCH CLARK*****************/
	@RequestMapping(value="/salvaDomanda", method=RequestMethod.POST)
	public String salvaDomanda(Model model, HttpServletRequest request) {
		
		// Prende gli attributi dalla view, per Domanda.
		String libro= request.getParameter("param_libro");
		int id=Integer.parseInt( request.getParameter("param_id"));
		int capitolo= Integer.parseInt(request.getParameter("param_capitolo"));
		int idDomanda=Integer.parseInt( request.getParameter("param_nDomanda"));
		String testo= request.getParameter("param_testo");
		String[] risposte= request.getParameter("param_risposte").split(";");
		String type= request.getParameter("param_type");
		String risposteEsatte= request.getParameter("param_risposteEsatte");
		String spiegazione= request.getParameter("param_spiegazione");

		
		List<Risposta> listRisposte= new ArrayList<Risposta>();
		Risposta ris= null;
		for(int i=0; i<risposte.length;i++) {
			ris= new Risposta();
			ris.setText(risposte[i]);
			ris.setValue(Character.toString((char)(65+i)));
			listRisposte.add(ris);
		}
		
		
		Domanda domanda= new Domanda(id,libro,capitolo,idDomanda,testo,type,listRisposte,risposteEsatte,spiegazione);
		
		//TODO manca metodo per prendere la dir del libro dal file index xml sapendo il titolo.
		
		
		//String directory=domanda.getBooks().getDir();
		
		//Clark: al posto di oca_manual ci deve essere directory, per adesso lo metto su oca manual
		//DISCLAIMER: se vuoi fare il debug cambia il numero del Padawan
		String path="C:\\Users\\Padawan14\\git\\Quiz\\domande\\oca_manual\\domande_cap"+capitolo+".xml";
		
		File fileXML=new File(path);

		Utils.aggiungiDomanda(domanda, fileXML);
		
//		Clark: per debug
//		List <Domanda> listaDomande=Utils.readFileDomande(fileXML.getPath());
//		for(Domanda d:listaDomande)
//			System.out.println(d);
	
		
		return "aggiungiDomanda";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************************/
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
