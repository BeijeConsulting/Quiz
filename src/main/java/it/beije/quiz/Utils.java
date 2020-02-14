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

	public static List<Element> getChildElements(Element element) { // prende un element con i corrispettivi figli
		// e li aggiunge in una lista di element, ti ridà i
		// figli già castati a element in una lista (prima
		// erano Node)
		List<Element> childElements = new ArrayList<Element>();

		NodeList nodeList = element.getChildNodes();
		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				childElements.add((Element) node);
			}
		}

		return childElements;
	}

	public static List<Domanda> readFileDomande(String pathFile) { //parsa l'xml domande.xml
		List<Domanda> arrayDomande = new ArrayList<Domanda>(); //preparo un arraylist che conterrà tutte le domande all'interno dell'XML

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Load the input XML document, parse it and return an instance of the
			// Document class.
			Document document = builder.parse(new File(pathFile));
			//prendo il tag domanda
			Element element = document.getDocumentElement();	        
			//	        System.out.println(element.getTagName());
			
			//prende i figli dell'element root (element root = domande)
			List<Element> domande = Utils.getChildElements(element);
			//	        System.out.println(domande);
			
			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;
			
			for (Element domanda : domande) {
				//per ogni elemento domanda prendo i corrispettivi figli
				contenutoDomanda = Utils.getChildElements(domanda);
				//settaggio attributi domanda
				int id = Integer.parseInt(domanda.getAttribute("id"));
				String book = domanda.getAttribute("book");
				int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
				int question = Integer.parseInt(domanda.getAttribute("question")); 
				
				//prendo l'elemento testo, e il suo contenuto
				String testo = contenutoDomanda.get(0).getTextContent();

				//prendo l'elemento che contiene le risposte
				rispostePossibili = contenutoDomanda.get(1);
				//prendo il tipo
				String answerType = rispostePossibili.getAttribute("type");
				
				//prendo gli elementi figli dell'elemento risposte
				elementiRisposta = Utils.getChildElements(rispostePossibili);
				List<Risposta> risposte = new ArrayList<Risposta>();
				for (Element risposta : elementiRisposta) {
					//per ogni elemento risposta di risposte
					Risposta r = new Risposta();
					r.setValue(risposta.getAttribute("value"));
					r.setText(risposta.getTextContent());
					//aggiungo alla lista risposte tutte le risposta
					risposte.add(r);
				}
				//prendo da domanda il contenuto dell'elemento rispostaEsatta
				String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
				//prendo da domanda il contenuto dell'elemtno spiegazione
				String spiegazione = contenutoDomanda.get(3).getTextContent();

				//popolo nel costruttore di domanda l'oggetto domanda
				Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
				//aggiungo all'array di domande che rstituirò popolato
				arrayDomande.add(d);

				//	        	System.out.println(d);
			}	        		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayDomande;
	}

	public static String formattaTesto(String testo) { //formatta il testo di una domanda in un formato html.
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}

		return testo;
	}

	public static boolean controllaRisposta(String rispostaEsatta, String risposta) { //controllo se la risposta data è esatta.
		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',')
				continue;
			if (rispostaEsatta.indexOf(c) < 0) {
				return false;// se non trovo la risposta termino il ciclo
			} else {
				// tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}

		return rispostaEsatta.length() == 0;
	}

}
