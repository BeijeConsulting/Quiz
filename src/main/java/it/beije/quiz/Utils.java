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
	
//	Metodo che ritorna gli elementi figli dell'elemento dato come parametro dento una util.list
//	Gestisce il casting a Element degli elementi node contenuti nella nodeList dei figli del parametro element
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

//	Lettura del documento XML, ritorna un alista di oggetti domanda
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

//			PRENDE I FIGLI DELL'ELEMENT ROOT	        
	        List<Element> domande = Utils.getChildElements(element);
//	        System.out.println(domande);
	        	        
	        List<Element> contenutoDomanda = null;
	        List<Element> elementiRisposta = null;
	        Element rispostePossibili = null;
	        
//	        PER OGNI ELEMENTO DOMANDA
	        for (Element domanda : domande) {
	        	
//	        	SI CARICA IN CONTENUTO DOMANDA TUTTI I FIGLI DI DOMANDA TESTO RISPOSTE RISPOSTA ESATTA E SPIEGAZIONE
	        	contenutoDomanda = Utils.getChildElements(domanda);
	        	
//	        	LETTURA ATTRIBUTI DI DOMANDA
		        int id = Integer.parseInt(domanda.getAttribute("id"));
		        String book = domanda.getAttribute("book");
		        int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
		        int question = Integer.parseInt(domanda.getAttribute("question"));
//		        PRENDO TESTO
		        String testo = contenutoDomanda.get(0).getTextContent();
		        
		        //caricare le risposte possibili
		        
//		        PRENDO RISPOSTE - ELEMENTO CHE CONTIENE LE RISPOSTE
		        rispostePossibili = contenutoDomanda.get(1);
//		        PRENDO L'UNICO ATTRIBUTO DELL'ELEMENT RISPOSTE
		        String answerType = rispostePossibili.getAttribute("type");
		        
//		        PRENDO TUTTI GLI ELEMENTI RISPOSTA DI RISPOSTE
		        elementiRisposta = Utils.getChildElements(rispostePossibili);
		        List<Risposta> risposte = new ArrayList<Risposta>();
//		        PER OGNI ELEMENTO RISPOSTA
		        for (Element risposta : elementiRisposta) {
		        	Risposta r = new Risposta();
		        	r.setValue(risposta.getAttribute("value"));
		        	r.setText(risposta.getTextContent());
//		        	POPOLO LA LISTA RISPOSTE CON LE VARIE RISPOSTA + ATTRIBUTO VALUE
		        	risposte.add(r);
		        }
//		        PRENDO RISPOSTA ESATTA ELEMENTO N°3 DELL'ELEMENT DOMANDA
		        String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
		        
//		        PRENDO SPIEGAZIONE ELEMENTO N°3 DELL'ELEMENT DOMANDA
		        String spiegazione = contenutoDomanda.get(3).getTextContent();
		        
//		        POPOLA NEL COSTRUTTORE DEL NUOVO OGGETTO CREATO DOMANDA CON I VARI ATTRIBUTI + RISPOSTE ECC..
	        	Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
//	        	AGGIUNGE ALLA LISTA PER IL RETURN
	        	arrayDomande.add(d);
	        	
//	        	System.out.println(d);
	        }	        		
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayDomande;
	}
//	FORMATTAZIONE DELL'ATTRIBUTO TESTO DELLA DOMANDA PER LA VISUALIZZAZIONE SU PAGINA WEB (SPAZIO E TAB IN HTML SONO RAPPRESENTATI DA UN ALTRO VALORE)
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
//	MATCH DELLA RISPOSTA CON LA RISPOSTA ESATTA GIA ESISTENTE
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
//			SE TORNA -1 VUOLE DIRE CHE NO TROVA NULLA E QUINDI TORNA FALSE
			if (rispostaEsatta.indexOf(c) < 0) {
				return false;//se non trovo la risposta termino il ciclo
			} else {
				//tolgo risposta esatta da elenco risposte esatte per evitare duplicati
//				SERVE PER L'INDEX OF SOPRA - NEL CASO IN CUI LA DOMANDA EERA A RISPOSTA MULTIPLA
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		
		return rispostaEsatta.length() == 0;
	}

}
