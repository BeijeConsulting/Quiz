package it.beije.quiz.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;


@Controller
public class QuizController {
	
	@Autowired
	private DomandaService domandaService;
	
	public static List<Domanda> domande;
	private static int tot;
	private static LocalTime time = null;
	

	@RequestMapping(value = "/storico", method = RequestMethod.GET)
	public static String storico(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {			
			return "storico";
		} else {
			return "forbidden";
		}
	}
	
	@RequestMapping(value = "/libro", method = RequestMethod.POST)
	public String libro(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {			
			String libro = request.getParameter("libro");
			List<String> capitoli = domandaService.getBooksChapters(libro);
			model.addAttribute("capitoli", capitoli);
			model.addAttribute("libro", libro);
			return "libro";
		} else {
			return "forbidden";
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {	
			List<String> libri = domandaService.getBooksNames();
			model.addAttribute("libri", libri);
			return "index";
		} else {
			return "forbidden";
		}
	}
	
	@RequestMapping(value = "/domanda", method = RequestMethod.GET)
	public String domanda(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {	
			String libro = request.getParameter("libro");
			List<String> capitoli = Arrays.asList(request.getParameterValues("capitolo"));
			List<Domanda> domande = domandaService.findByBookAndChapters(libro, capitoli);
			session.setAttribute("domande", domande);
			session.setAttribute("capitoli", capitoli);
			session.setAttribute("libro", libro);
			String url = "domanda/" + domande.get(0).getQuestion();
			setTimer(model);
			return url;
		} else {
			return "forbidden";
		}
	}
	
	@RequestMapping(value = "/domanda/{id}", method = RequestMethod.GET)
	public String domandaNumero(@PathVariable Integer id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {	
			List<Domanda> domande = (List<Domanda>) session.getAttribute("domande");
			session.setAttribute("domande", domande);
			model.addAttribute("capitoli", domande.get(id).getChapter());
			model.addAttribute("libro", domande.get(id).getBook());
			String url = "domanda/" + domande.get(id).getQuestion();
			setTimer(model);
			return url;
		} else {
			return "forbidden";
		}
	}
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public static String init(HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {
//			
//			if (domande == null) {
//				domande = Utils.readFileDomande("C:\\temp\\domande\\oca_certification_guide_manning\\domande_cap1.xml");
//				tot = domande.size();
//			}
//			
//			model.addAttribute("totDomande", tot);
//			
//			return "index";
//		} else {
//			return "forbidden";
//		}
//	}
	
	public static void setTimer(Model model) {
		if (time == null) {
			time = LocalTime.now();
		}
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		System.out.println("###################-> " + domande);
		int tot;
		if(domande != null) {
			tot = domande.size();
		}
		else {
			tot = 0;
		}
		System.out.println("###################-> " + domande);
		int secondi = 2 * 60 * tot;
		long hours = (secondi - diff.getSeconds())/3600;
		long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;
		
		model.addAttribute("totDomande", tot);
		model.addAttribute("ore", hours);
		model.addAttribute("minuti", minutes);
		model.addAttribute("secondi", seconds);
	}
	
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
	
//	@RequestMapping(value = "/domanda/{index}", method = RequestMethod.GET)
//	public String domanda(HttpServletRequest request, Model model, @PathVariable("index") int index) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {
//		
//			setTimer(model);
//			
//			return caricaDomanda(model, index);
//		}
//		else {
//			return "forbidden";
//		}
//	}
	
//	@RequestMapping(value = "/domanda", method = RequestMethod.POST)
//	public String risposta(Model model, HttpServletRequest request,
//			@RequestParam("index") int index) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {
//		
//			Enumeration<String> enums = request.getParameterNames();
//			StringBuilder builder = new StringBuilder();
//			while (enums.hasMoreElements()) {
//				String name = enums.nextElement();
//				//System.out.println(name + " : " + request.getParameter(name));
//				if (name.startsWith("rspt_")) {
//					builder.append(request.getParameter(name));
//				}
//			}
//			domande.get(index).setRispostaUtente(builder.toString());
//			
//			setTimer(model);
//			
//			return caricaDomanda(model, ++index);
//		}
//		else {
//			return "forbidden";
//		}
//	}

//	@RequestMapping(value = "/risultati", method = RequestMethod.GET)
//	public String risultati(HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("auth") != null && (boolean)session.getAttribute("auth")) {
//			//ELABORAZIONE RISPOSTE
//			StringBuilder builder = new StringBuilder();
//			for (Domanda d : domande) {
//				boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
//				
//				builder.append("DOMANDA " + d.getId() + " : la tua risposta : " + d.getRispostaUtente() + "<br><br>");
//				if (corretta) {
//					builder.append("ESATTO!!! :)<br>");
//				} else {
//					builder.append("La risposta esatta era " +  d.getRispostaEsatta() + " :(<br>");
//				}
//				
//				builder.append("<br><br>");
//			}
//			
//			model.addAttribute("body", builder.toString());
//			
//			return "risultati";
//		}
//		else {
//			return "forbidden";
//		}
//	}
	
	/////// REST
	
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
