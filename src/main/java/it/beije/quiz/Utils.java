package it.beije.quiz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.quiz.jpa.JPAUtils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
//import it.beije.quiz.model.Risposta;
//import it.beije.quiz.repository.DomandaRepository;
import it.beije.quiz.service.DomandaService;
import it.beije.quiz.service.RispostaService;

public class Utils {
	/*
	 * Formattazione testo: fa in modo che i vari "a capo" e le tab vengano rispettate anche in una pagina HTML
	 */
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
	/*
	 * Vengono date le risposte date dagli utenti e la risposta esatta.
	 * Il risultato � se l'utente ha dato la risposta corretta.
	 */
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		rispostaEsatta = rispostaEsatta.replace(" ", "").replace(",", ""); // Bug fixato
		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
			if (rispostaEsatta.indexOf(c) < 0) {
				return false;//se non trovo la risposta termino il ciclo
			} else {
				//tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		
		return rispostaEsatta.length() == 0;
	}

	
	//PARSE DOMANDA E RISPOSTA DA XML A DATABASE 
	public void xmlToDatabase(String pathFile) throws ParserConfigurationException, SAXException, IOException {
		List<Domanda> domande = new ArrayList<Domanda>();
		List<Risposta> answers = new ArrayList<Risposta>();
		File inputFile = new File(pathFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);
        document.getDocumentElement().normalize();
        
        NodeList nodeList = document.getElementsByTagName("domanda");
        for (int i = 0; i < 1 /*nodeList.getLength()*/; i++) {
        	Node node = nodeList.item(i);
        	if (node.getNodeType() == node.ELEMENT_NODE) {
        		Element element = (Element) node;
        		Long idDomanda = Long.parseLong(element.getAttribute("id"));
        		String book = element.getAttribute("book");
        		Integer chapter = Integer.parseInt(element.getAttribute("chapter"));
        		Integer question = Integer.parseInt(element.getAttribute("question"));
        		String testo = element.getElementsByTagName("testo").item(0).getTextContent();
        		System.out.println("TESTO ---> " + testo);
        		String spiegazione = element.getElementsByTagName("spiegazione").item(0).getTextContent();
        		String type = "";
        		String risposteEsatte = element.getElementsByTagName("risposteEsatte").item(0).getTextContent();
        		
        		NodeList nodeList2 = element.getElementsByTagName("risposte");
        		Node node2 = nodeList2.item(0);
        		if (node2.getNodeType() == node2.ELEMENT_NODE) {
        			Element element2 = (Element) node2;
        			type = element2.getAttribute("type");
        			
        			NodeList nodeList3 = element.getElementsByTagName("risposta");
        			for (int j = 0; j < nodeList3.getLength(); j++) {
        				Node node3 = nodeList3.item(j);
        				String risposta = node3.getTextContent();
        				if (node3.getNodeType() == node3.ELEMENT_NODE) {
        					Element element3 = (Element) node3;
        					String lettera = element3.getAttribute("value");
        					boolean corretto = false;
        					if (risposteEsatte.replace(", ", "").equals(lettera)) {
        						corretto = true;
        					}
        					JPAUtils.insertRisposta(idDomanda, lettera, risposta, corretto);
        				}
        			}
        		}
        		JPAUtils.insertDomanda(book, chapter, question, testo, type, spiegazione);
        	}
        }
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Utils utils = new Utils();
		utils.xmlToDatabase("/temp/domande_cap1.xml");
		System.out.println("DONE");
	}
}
