package it.beije.quiz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

public class Utils {
	
	/*
	 * Restituisce la lista di Element figli dell'element passato come parametro
	 */
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		
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

	/*
	 * Legge il file .xml contenente le domande del quiz,
	 * compone una lista di domande e la restituisce
	 */
	public static List<Domanda> readFileDomande(String pathFile) {
		List<Domanda> arrayDomande = new ArrayList<Domanda>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(new File(pathFile));
	        Element element = document.getDocumentElement();	        
//	        System.out.println(element.getTagName());
	        // restituisce lista di domanda
	        List<Element> domande = Utils.getChildElements(element);
//	        System.out.println(domande);
	        	        
	        List<Element> contenutoDomanda = null;
	        List<Element> elementiRisposta = null;
	        Element rispostePossibili = null;
	        for (Element domanda : domande) {
	        	
	        	contenutoDomanda = Utils.getChildElements(domanda);
	        	
	        	// prende gli attributi
		        int id = Integer.parseInt(domanda.getAttribute("id"));
		        String book = domanda.getAttribute("book");
		        int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
		        int question = Integer.parseInt(domanda.getAttribute("question"));
		        
		        // prende il testo della domanda
		        String testo = contenutoDomanda.get(0).getTextContent();
		        
		        // caricare le risposte possibili
		        rispostePossibili = contenutoDomanda.get(1);
		        String answerType = rispostePossibili.getAttribute("type");
		        elementiRisposta = Utils.getChildElements(rispostePossibili);
		        List<Risposta> risposte = new ArrayList<Risposta>();
		        for (Element risposta : elementiRisposta) {
		        	Risposta r = new Risposta();
		        	r.setValue(risposta.getAttribute("value"));
		        	r.setText(risposta.getTextContent());
		        	
		        	risposte.add(r);
		        }
		        
		        // legge le risposte esatte
		        String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
		        
		        // legge la spiegazione
		        String spiegazione = contenutoDomanda.get(3).getTextContent();
		        
		        // crea l'oggetto domanda e o aggiunge alla lista arrayDomande
	        	Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
	        	arrayDomande.add(d);
	        	
//	        	System.out.println(d);
	        }	        		
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayDomande;
	}
	
	/*
	 * sostituisce il '\n' con <br> e '\t' con 4 spazi 
	 */
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
	/*
	 * Legge la stringa della risposta dell'utente carattere per carattere.
	 * Salta i caratteri 'spazio' e ','
	 * Se il carattere della risposta dell'utente non è presente nella stringa delle risposte esatte 
	 * esce dal ciclo e ritorna false.
	 * In caso contrario la risposta corretta dell'utente viene eliminata dalla stringa delle risposte
	 * corrette per evitare duplicati.
	 * Il ciclo for continua fino alla completa scansione della stringa della risposta data dall'utete.
	 * 
	 * Ritorna l'esito del controllo della lunghezza della stringa risposte corrette == 0
	 */
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
			if (rispostaEsatta.indexOf(c) < 0) {
				return false; //se non trovo la risposta termino il ciclo
			} else {
				//tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		
		return rispostaEsatta.length() == 0;
	}
	
	
	public static void writeXML(Domanda domanda) throws TransformerException, ParserConfigurationException, SAXException, IOException {
	
		String pathXML = "domande/" + domanda.getBook() + "/domande_cap" + domanda.getChapter() + ".xml";
		System.out.println(pathXML);
		
		File f = new File(pathXML);
		System.out.println(f.getAbsolutePath());
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("domande");
		document.appendChild(docElement);
		
		// domande
		
	
		// domanda
		Element question = document.createElement("domanda");
		question.setAttribute("id", ""+domanda.getId());
		question.setAttribute("book", domanda.getBook());
		question.setAttribute("chapter", ""+domanda.getChapter());
		question.setAttribute("question", ""+domanda.getQuestion());

		// testo domanda
		Element testo = document.createElement("testo");
		testo.setTextContent(domanda.getTesto());
		question.appendChild(testo);

		// risposte
		Element risposte = document.createElement("risposte");
		risposte.setAttribute("type", domanda.getAnswerType());
		question.appendChild(risposte);

		for(Risposta r : domanda.getRisposte()) {
			Element risp = document.createElement("risposta");
			risp.setAttribute("value", r.getValue());
			risp.setTextContent(r.getText());

			risposte.appendChild(risp);
		}
		
		// risposteEsatte
		Element risposteEsatte = document.createElement("risposteEsatte");
		risposteEsatte.setTextContent(domanda.getRispostaEsatta());
		question.appendChild(risposteEsatte);
		
		// spiegazione
		Element spiegazione = document.createElement("spiegazione");
		spiegazione.setTextContent(domanda.getSpiegazione());
		question.appendChild(spiegazione);

		docElement.appendChild(question);
	
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathXML));
	
		transformer.transform(source, result);
	
	}


}
