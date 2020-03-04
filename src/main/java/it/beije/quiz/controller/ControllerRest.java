package it.beije.quiz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;

@RestController
public class ControllerRest {

	
	//TODO: ds testare
	@RequestMapping(value="/caricaDomanda/{dirLibro}/{capitolo}/{nDomanda}", method=RequestMethod.GET)
	public @ResponseBody Domanda getDomanda(@PathVariable String dirLibro, @PathVariable int capitolo, @PathVariable int nDomanda ){
		List <Domanda> listaDomande= new ArrayList<Domanda>();
		List<File> listaFile= Utils.selezionaFileDiInteresse(dirLibro);
		
		for(File f: listaFile) {

			listaDomande.addAll(Utils.readFileDomande(f.getPath()));
		}

		String idDomanda=dirLibro+"|"+capitolo+"|"+nDomanda;
		for(Domanda d: listaDomande)
			if(d.getId().equals(idDomanda))
				return d;
		
		return null;
		

	}

	@RequestMapping(value = "/caricaDomande/{dirLibro}/{capitolo}", method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable String dirLibro, @PathVariable int capitolo) {
		List<Domanda> listaDomande = new ArrayList<Domanda>();
		List<File> listaFile = Utils.selezionaFileDiInteresse(dirLibro);

		for (File f : listaFile) {
			List<Domanda> listaD = new ArrayList<Domanda>();
			listaD.addAll(Utils.readFileDomande(f.getPath()));
			for (Domanda d : listaD) {
				if (d.getChapter() == capitolo)
					listaDomande.add(d);

			}
		}
		return listaDomande;

	}

	@RequestMapping(value = "/insertDomanda", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda insertDomande(@RequestBody Domanda domanda) {
		List<Libro> listaLibriInXML = Utils
				.caricaLibriDaIndexXML("C:\\Users\\Padawan14\\git\\Quiz\\domande\\index.xml");

		boolean vero = false;
		StringBuilder path = new StringBuilder();
        String dir=Utils.getDirectory(domanda.getId());
		for (Libro l : listaLibriInXML) {
			if (dir.equals(l.getDir())) {
				vero = true;
				break;
			}
		}
		path.append("C:\\Users\\Padawan14\\git\\Quiz\\domande\\").append(dir);
		File file = new File(path.toString());
		if (vero != true) {
			file.mkdir();
			Libro l = new Libro();
			l.setDir(dir);
			l.setIdBook(dir);
			l.setTitle(domanda.getBook());
			listaLibriInXML.add(l);
			try {
				Utils.scriviSuXML(listaLibriInXML,"C:\\Users\\Padawan14\\git\\Quiz\\domande\\index.xml");
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
	public @ResponseBody List<Domanda> insertDomande(@RequestBody List <Domanda> domande) {
	
		
		for (Domanda dom : domande) {	
			StringBuilder path = new StringBuilder();
			String dir =Utils.getDirectory(dom.getId());
			path.append("C:\\Users\\Padawan14\\git\\Quiz\\domande\\").append(dir);
			File file = new File(path.toString());
			if (!file.exists()) {
				file.mkdir();
				Libro l = new Libro();
				l.setDir(dir);
				l.setIdBook(dir);
				l.setTitle(dom.getBook());
				List <Libro> lista= Utils.caricaLibriDaIndexXML("C:\\Users\\Padawan14\\git\\Quiz\\domande\\index.xml");
				lista.add(l);
				try {
					
					Utils.scriviSuXML(lista,"C:\\Users\\Padawan14\\git\\Quiz\\domande\\index.xml");
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
	
	@RequestMapping(value = "/deleteDomanda/{dirLibro}/{capitolo}/{nDomanda}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean  deleteDomanda(@PathVariable String dirLibro, @PathVariable int capitolo, @PathVariable int nDomanda, HttpServletResponse response) {
		Domanda d= getDomanda(dirLibro,capitolo,nDomanda);
		if(d==null) {
			response.setStatus(204);
			return false;
		}
		else {
			StringBuilder path = new StringBuilder("C:\\Users\\Padawan07\\git\\Quiz\\domande\\"+dirLibro+"\\domande_cap"+ capitolo +".xml");
	        String pathdomanda= path.toString();
			File file2=new File(pathdomanda);
			Utils.eliminaDomanda(d,file2);
			return true;
			
		}
		
	}
	
	}
	
	
	
