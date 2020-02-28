package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
	
	private List<Domanda> domande=new ArrayList<>();
	private int tot ;
	private LocalTime time = null;
	List<Libro> libri=new ArrayList<>();
	String[] checkboxValues;
	private int globalNumeroRisposte;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model, HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		String[] checkboxValues=null;
		List<Libro> libri= Utils.readFileLibri();

		
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
		model.addAttribute("newDomandaCreata","");
		
		
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
				System.out.println(v);
				for(Libro l : libri) {
					if(l.getIdBook().equals(v)) {
						domande.addAll(l.caricaQuestions());
						System.out.println(domande.toString());
					}
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
	
	@RequestMapping(value = "/NewDomanda", method = RequestMethod.GET)
	public String newDomandaGet(Model model) {
		model.addAttribute("bookType", true);
		model.addAttribute("libri", libri);
		model.addAttribute("pathController", "NewDomanda");
		
		return "NewDomanda";
	}
	@RequestMapping(value = "/NewDomanda", method = RequestMethod.POST)
	public String newDomandaPost(Model model,HttpServletRequest request,HttpSession session) {
		
		int numeroRisposte = Integer.parseInt(request.getParameter("numeroRisposte"));
		globalNumeroRisposte=numeroRisposte;
		
		String book = request.getParameter("book");
		int chapter = Integer.parseInt(request.getParameter("chapter"));
		int question = Integer.parseInt(request.getParameter("question"));
		String testo = request.getParameter("testo");
		String answerType = request.getParameter("answerType");
		String bookType = request.getParameter("bookSelection");
		String chapterString = request.getParameter("chapterString");
		
		String answerTypeRadio="";
		String answerTypeCheckbox="";
		
		for(Libro l : libri) 
			if (bookType.equals(l.getIdBook())) l.setChecked("checked");
		
		StringBuilder datiLibro = new StringBuilder("");
		if (bookType.equals("new")) {
			model.addAttribute("checkedNewBook", "checked");
			model.addAttribute("bookTypeButton", true);
			model.addAttribute("pathController", "NewLibro");
			
			datiLibro.append("<h5>INSERIRE ID LIBRO..</h5>");
			datiLibro.append("<input type=\"text\" name=\"idBook\"><br>");
			datiLibro.append("<h5>INSERIRE TITOLO DEL LIBRO..</h5>");
			datiLibro.append("<input type=\"text\" name=\"title\"><br>");
			datiLibro.append("<h5>INSERIRE DIRECTORY DI RIFERIMENTO..</h5>");
			datiLibro.append("<input type=\"text\" name=\"nameDir\"><br><br>");
			model.addAttribute("datiLibro", datiLibro.toString());
		}else { 
			model.addAttribute("checkedNewBook", "");
			model.addAttribute("bookTypeButton", false);
			model.addAttribute("bookType", false);
			model.addAttribute("pathController", "index");
		}
		
		if (answerType.equals("radio"))
			answerTypeRadio="checked"; 
		else
			answerTypeCheckbox="checked";
		
			
		model.addAttribute("chapterString",chapterString);
		model.addAttribute("answerType",answerType);
		model.addAttribute("numeroRisposte",numeroRisposte);
		model.addAttribute("book",book);
		model.addAttribute("chapter",chapter);
		model.addAttribute("question",question);
		model.addAttribute("testo",testo);
		model.addAttribute("answerTypeRadio",answerTypeRadio);
		model.addAttribute("answerTypeCheckbox",answerTypeCheckbox);
		model.addAttribute("libri", libri);
		
		return "NewDomanda";
	}
	
	@RequestMapping(value = "/NewLibro", method = RequestMethod.POST)
	public String newLibro(HttpServletRequest request,Model model) {
		
		List<Risposta> risposte = new ArrayList<>();

		
		String book = request.getParameter("book");
		int chapter = Integer.parseInt(request.getParameter("chapter"));
		int question = Integer.parseInt(request.getParameter("question"));
		String testo = request.getParameter("testo");
		String answerType = request.getParameter("answerType");
		String spiegazione = request.getParameter("spiegazione");
		
		for (int cont = 0; cont < globalNumeroRisposte; cont++) {
			Risposta risp = new Risposta();
			risp.setText(request.getParameter("r"+cont));
			risp.setValue(((char)(cont+65))+"");
			risposte.add(risp);
		}
		
		StringBuilder soluzioni = new StringBuilder();
		int singolaRispostaEsatta ;
		
		if (answerType.equals("radio")) {
			singolaRispostaEsatta = Integer.parseInt(request.getParameter("rispostaEsatta"));
			soluzioni.append((char)(singolaRispostaEsatta+65));
		}
		
		
		String arrRispostaEsatta[];
		
		if (answerType.equals("checkbox")) {
			arrRispostaEsatta = request.getParameterValues("rispostaEsatta");
			
			for(String s : arrRispostaEsatta)
				soluzioni.append((char)(Integer.parseInt(s)+65));
		}
		
		String rispostaEsatta = soluzioni.toString();
		
		Libro libro = new Libro();
		libro.setIdBook(request.getParameter("idBook"));
		libro.setTitle(request.getParameter("title"));
		libro.setNameDir(request.getParameter("nameDir"));
		
		String nomeFile = request.getParameter("chapterString");
		
		Domanda domanda = new Domanda(null,libro.getTitle() ,chapter,question,testo,answerType,risposte,rispostaEsatta,spiegazione);
		System.out.println(domanda.toString());
		
		Utils.caricaDomande(libro,nomeFile,domanda);
		
		model.addAttribute("newDomandaCreata","Nuova domanda inserita correttamente");
		
		return "index";
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
