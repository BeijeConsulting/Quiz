package it.beije.quiz.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping(value = "/domande", method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getRubricaFromCSV() throws ParserConfigurationException, SAXException, IOException {
		List<Domanda> domande = new ArrayList<Domanda>();
		File f = new File("C:\\Users\\Padawan04\\git\\Quiz\\domande\\");
		String dir = "";
		for(File file : f.listFiles()) {
			if(file.isDirectory()) {
				dir = file.getName();
				for(File ff : file.listFiles()) {
					domande.addAll(Utils.readFileDomande(ff.getAbsolutePath(), dir));
				}
			} 
		}
		return domande;
	}
	
	@RequestMapping(value = "/newdomanda", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Domanda newDomanda(@RequestBody Domanda domanda) throws Exception {
		Utils.writeDomandeXML(domanda, "C:\\Users\\Padawan04\\git\\Quiz\\domande\\nostro_libro\\pippo.xml");
		return domanda;
	}
	
}
