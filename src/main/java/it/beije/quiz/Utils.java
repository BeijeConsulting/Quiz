package it.beije.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

public class Utils {

	/**
	 * Metodo util per la lettura di file XML
	 * @param element Elemento da cui estrarre gli elementi child
	 * @return List di elements figli dell'element parametro
	 */
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<>();
		NodeList nodeList = element.getChildNodes();
        Node node = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
        	node = nodeList.item(i);
        	if (node.getNodeType() == Node.ELEMENT_NODE) {
        		childElements.add((Element)node);
        	}
        }
		return childElements;
	}

	/**
	 * Legge un file xml e crea una lista di oggetti Domanda
	 * @param pathFile la path del file xml da cui leggere le domande
	 * @return la lista di domande
	 */
	public static List<Domanda> readFileDomande(String pathFile) {
		List<Domanda> arrayDomande = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(new File(pathFile));
	        Element element = document.getDocumentElement();	        
	        List<Element> domande = Utils.getChildElements(element);

	        List<Element> contenutoDomanda = null;
	        List<Element> elementiRisposta = null;
	        Element rispostePossibili = null;
	        for (Element domanda : domande) {
	        	contenutoDomanda = Utils.getChildElements(domanda);
		        int id = Integer.parseInt(domanda.getAttribute("id"));
		        String book = domanda.getAttribute("book");
		        int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
		        int question = Integer.parseInt(domanda.getAttribute("question"));
		        String testo = contenutoDomanda.get(0).getTextContent();
		        
		        //caricare le risposte possibili
		        rispostePossibili = contenutoDomanda.get(1);
		        String answerType = rispostePossibili.getAttribute("type");
		        elementiRisposta = Utils.getChildElements(rispostePossibili);
		        List<Risposta> risposte = new ArrayList<>();
		        for (Element risposta : elementiRisposta) {
		        	Risposta r = new Risposta();
		        	r.setValue(risposta.getAttribute("value"));
		        	r.setText(risposta.getTextContent());
		        	
		        	risposte.add(r);
		        }
		        String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
		        String spiegazione = contenutoDomanda.get(3).getTextContent();
		        
	        	Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
	        	arrayDomande.add(d);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayDomande;
	}

	/**
	 * Formatta una Stringa
	 * @param testo String da formattare
	 * @return La String formattata
	 */
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		return testo;
	}

	/**
	 * Controlla se la risposta data dall'utente corrisponde alla risposta esatta
	 * @param rispostaEsatta La risposta esatta
	 * @param risposta La risposta dell'user
	 * @return true se rispostaEsatta == risposta
	 */
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		// Rimuovo le virgole dalla risposta esatta e la formatto tutta unita (A, B, C diventa ABC)
		// perché è il formato con cui viene ricevuta la risposta. Senza questa conversione tutte le
		// risposte sono errate
		rispostaEsatta = rispostaEsatta.replace(", ", "");

		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
			if (rispostaEsatta.indexOf(c) < 0) {
				return false; // Se non trovo la risposta termino il ciclo perché sicuro è errata
			} else {
				// Tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		return rispostaEsatta.length() == 0;
	}
}