package it.beije.quiz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.service.QuizService;

@RestController
public class ControllerRest {

	@Autowired
	private QuizService quizService;

	private List<File> listaFile = null;

//	
//	@RequestMapping(value="/caricaDomanda/{dirLibro}/{capitolo}/{nDomanda}", method=RequestMethod.GET)
//	public @ResponseBody Domanda getDomanda(@PathVariable String dirLibro, @PathVariable int capitolo, @PathVariable int nDomanda ){
//		List <Domanda> listaDomande= new ArrayList<Domanda>();
//		List<File> listaFile= Utils.selezionaFileDiInteresse(dirLibro);
//
//		for(File f: listaFile) {
//
//
//			listaDomande.addAll(Utils.readFileDomande(f.getPath()));
//		}
//
//		String idDomanda = dirLibro + "|" + capitolo + "|" + nDomanda;
//		for (Domanda d : listaDomande)
//			if (d.getId().equals(idDomanda))
//				return d;
//
//		return null;
//
//
//	}

	@RequestMapping(value = "/domande/{dirLibro}/{capitolo}", method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable String dirLibro, @PathVariable int capitolo,
			@RequestParam(name = "nDomanda", required = false) Integer nDomanda) {
		List<Domanda> listaDomande = quizService.getDomande();
		List<Domanda> domande = new ArrayList<Domanda>();

		if (nDomanda == null) {
			for (Domanda d : listaDomande)
				if (d.getChapter() == capitolo && Utils.getDirectory(d.getId()).equals(dirLibro))
					domande.add(d);
		} else {
			String idDomanda = dirLibro + "|" + capitolo + "|" + nDomanda;

			for (Domanda d : listaDomande)
				if (d.getId().equals(idDomanda)) {
					domande.add(d);
					break;
				}

		}

		return domande;

	}

	@RequestMapping(value = "/insertDomanda", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda insertDomande(@RequestBody Domanda domanda) {
	
		boolean vero = false;
		StringBuilder path = new StringBuilder();
		String dir = Utils.getDirectory(domanda.getId());

		for (Libro l : quizService.getListaLibri()) {
			if (dir.equals(l.getDir())) {
				vero = true;
				break;
			}
		}
		path.append(quizService.getBaseDirectory()).append(dir);
		File file = new File(path.toString());
		if (vero != true) {
			file.mkdir();
			Libro l = new Libro();
			l.setDir(dir);
			l.setIdBook(dir);
			l.setTitle(domanda.getBook());
			quizService.getListaLibri().add(l);
			try {
				Utils.scriviSuXML(quizService.getListaLibri(), "C:\\Users\\Padawan07\\git\\Quiz\\domande\\index.xml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String pathdomanda = path.toString() + "\\" + "domande_cap" + domanda.getChapter() + ".xml";
		File file1 = new File(pathdomanda);
		Utils.aggiungiDomanda(domanda, file1);
		return domanda;

	}

	@RequestMapping(value = "/insertListaDomande", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> insertDomande(@RequestBody List<Domanda> domande) {

		for (Domanda dom : domande) {
			StringBuilder path = new StringBuilder();
			String dir = Utils.getDirectory(dom.getId());
			path.append("C:\\Users\\Padawan07\\git\\Quiz\\domande\\").append(dir);
			File file = new File(path.toString());
			if (!file.exists()) {
				file.mkdir();
				Libro l = new Libro();
				l.setDir(dir);
				l.setIdBook(dir);
				l.setTitle(dom.getBook());
				List<Libro> lista = Utils.caricaLibriDaIndexXML("C:\\Users\\Padawan07\\git\\Quiz\\domande\\index.xml");
				lista.add(l);
				try {

					Utils.scriviSuXML(lista, "C:\\Users\\Padawan07\\git\\Quiz\\domande\\index.xml");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			file = new File(path.toString() + "\\domande_cap" + dom.getChapter() + ".xml");
			Utils.aggiungiDomanda(dom, file);
		}
		return domande;
	}

	@RequestMapping(value = "/aggiornaDomanda", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Domanda> updateListaDomande(@RequestBody List<Domanda> domande,
			HttpServletResponse response) {
		List<Domanda> listaDomandeAggiornate = new ArrayList<Domanda>();
		if (domande.size() == 1) {
			listaDomandeAggiornate.add(quizService.aggiornaDomanda(domande.get(0)));
			
		} else {
			
			Domanda d = null;
			for (Domanda domanda : domande) {
				d = quizService.aggiornaDomanda(domanda);
				if (d != null)
					listaDomandeAggiornate.add(domanda);
				else {
					response.setStatus(204);
					break;
				}

			}

			if (listaDomandeAggiornate == null)
				response.setStatus(204);

		}
		return listaDomandeAggiornate;

	}

	

	@RequestMapping(value = "/deleteDomanda", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteDomanda(HttpServletResponse response,
			@RequestParam(name = "idDomanda", required = true) String idDomanda) {

		String dirLibro = Utils.getDirectory(idDomanda);
		int capitolo = Utils.getCapitolo(idDomanda);
		int nDomanda = Utils.getNDomanda(idDomanda);
		Domanda d = getDomande(dirLibro, capitolo, nDomanda).get(0);
		if (d == null) {
			response.setStatus(204);
			return false;
		} else {
			StringBuilder path = new StringBuilder(
					quizService.getBaseDirectory() + dirLibro + "\\domande_cap" + capitolo + ".xml");
			String pathdomanda = path.toString();
			File file2 = new File(pathdomanda);
			Utils.eliminaDomanda(d, file2);
			return true;

		}

	}

//	@RequestMapping(value = "/deleteDomande", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody void deleteDomande(@RequestBody List <Domanda> domande, HttpServletResponse response){
//		
//		for(Domanda d: domande) {
//			int nDomanda= d.getQuestion();
//			String dirLibro=Utils.getDirectory(d.getId());
//			int capitolo=d.getChapter();
//			deleteDomanda(dirLibro,capitolo,nDomanda,response);
//			}
//		}

}