package it.beije.quiz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
