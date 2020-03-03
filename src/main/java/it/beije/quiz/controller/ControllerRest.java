package it.beije.quiz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	@RequestMapping(value="/caricaDomanda/{idDomanda}", method=RequestMethod.GET)
	public @ResponseBody Domanda getDomanda(@PathVariable String idDomanda){
		List <Domanda> listaDomande= new ArrayList<Domanda>();
		List<File> listaFile= Utils.selezionaFileDiInteresse(Utils.getDirectory(idDomanda));
		
		for(File f: listaFile) {

			listaDomande.addAll(Utils.readFileDomande(f.getPath()));
		}

		
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

	@RequestMapping(value = "/insertdomande", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda insertDomande(@RequestBody Domanda domanda) {
		List<Libro> listaLibriInXML = Utils
				.caricaLibriDaIndexXML("C:\\Users\\Padawan01\\git\\Quiz\\domande\\index.xml");

		boolean vero = false;
		StringBuilder path = new StringBuilder();
        String dir=Utils.getDirectory(domanda.getId());
		for (Libro l : listaLibriInXML) {
			if (dir.equals(l.getDir())) {
				vero = true;
				break;
			}
		}
		path.append("C:\\Users\\Padawan01\\git\\Quiz\\domande\\").append(dir);
		File file = new File(path.toString());
		if (vero != true) {
			file.mkdir();
		}
		String pathdomanda = path.toString() + "\\" + "domande_cap" + domanda.getChapter() + ".xml";
		File file1 = new File(pathdomanda);
		Utils.aggiungiDomanda(domanda, file1);
		return domanda;

	}

	
	@RequestMapping(value = "/insertdomande/{dir}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void insertDomande(@RequestBody ArrayList<Domanda> domande) {
	
		
		for (Domanda dom : domande) {	
			StringBuilder path = new StringBuilder();
			String dir =Utils.getDirectory(dom.getId());
			path.append("C:\\Users\\Padawan01\\git\\Quiz\\domande\\").append(dir);
			File file = new File(path.toString());
			if (!file.exists()) {
				file.mkdir();
			}
			file = new File(path.toString() + "\\domande_cap" + dom.getChapter() + ".xml");
			Utils.aggiungiDomanda(dom, file);
		}
	}

}
