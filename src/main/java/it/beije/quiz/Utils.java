package it.beije.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

public class Utils {

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		//CE 20200214: prende tutti i nodi figli di element, quindi sia i nodi attributi che nodi elementi
		NodeList nodeList = element.getChildNodes();
		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);

			//CE 20200214: se il nodo è un elemento allora lo aggiungo alla lista di nodi figli elemento.
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				childElements.add((Element)node);
			}
		}
		//CE 20200214: ritorna una lista di elementi dei figli di tipo element
		return childElements;
	}

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

			//CE 20200213:Inizializza la lista, con dentro le domande (domande=[domanda1, domanda2,ecc.]
			List<Element> domande = Utils.getChildElements(element);
			//	        System.out.println(domande);

			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;

			//CE 20200213: per ogni elemento domanda estrapolo gli elementi: testo, risposte, risposte esatte, spiegazione
			for (Element domanda : domande) {
				//CE 20200213: carico in una lista gli elementi figli della donmanda (contenutoDomanda=[testo,risposte,risposteEsatte,spiegazione].
				contenutoDomanda = Utils.getChildElements(domanda);

				//CE 20200213: prende l'attributo id della domanda
				int id = Integer.parseInt(domanda.getAttribute("id"));
				String book = domanda.getAttribute("book");

				//CE 20200213: prende l'attributo chapter della domanda
				int chapter = Integer.parseInt(domanda.getAttribute("chapter"));

				//CE 20200213: prende l'attributo question della domanda
				int question = Integer.parseInt(domanda.getAttribute("question"));

				//CE 20200213: il testo della domanda, get(0) prende l'elemento figlio ="testo", e getTextContent prende il contenuto del testo.
				String testo = contenutoDomanda.get(0).getTextContent();

				//caricare le risposte possibili
				rispostePossibili = contenutoDomanda.get(1);
				String answerType = rispostePossibili.getAttribute("type");

				//CE 20200213: estrapola le singole risposte (elementiRisposta=[risposta1,risposta2,risposta3,ecc.]
				elementiRisposta = Utils.getChildElements(rispostePossibili);

				//CE 20200214: crea lista di oggetti risposta (Javabean) e settando gli attributi.
				List<Risposta> risposte = new ArrayList<Risposta>();
				for (Element risposta : elementiRisposta) {
					Risposta r = new Risposta();
					r.setValue(risposta.getAttribute("value"));
					r.setText(risposta.getTextContent());
					risposte.add(r);
				}

				//CE 20200214: salva il valore della risposta esatta, e della spiegazione in due variabili diverse.
				String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
				String spiegazione =contenutoDomanda.get(3).getTextContent();

				//CE 202200214: crea la domanda con tutti i dati, e la aggiunge in nella lista arrayDomande.
				Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
				arrayDomande.add(d);

				//	        	System.out.println(d);
			}	        		

		} catch (Exception e) {
			e.printStackTrace();
		}
		//CE 20200214: ritorno una lista di oggetti domanda, con tutti i suoi attributi. In questo modo ho "parsato" gli elementi domanda in oggetti javaBean.
		return arrayDomande;
	}


	public static String formattaTesto(String testo) {
		//CE 20200214: controlla che il testo non sia nulla o vuota.
		if (testo != null && testo.length() > 0) {
			//CE 20200214: "modifica" il testo per farlo visualizzare in html
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		//CE 20200214: ritorna il testo in html
		return testo;
	}

	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		//CE 20200214: con la risposta data controlla se è uguale alla risposta esatta 
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
		//CE 20200214: se è 0 allora ho dato la risposta esatta 
		return rispostaEsatta.length() == 0;
	}
	
	
	//CE 20200214: Aggiunti metodi per scrivere nel xml una nuova domanda
	
	
	public static void aggiungiDomanda(Domanda domanda, File fileXML) {
		List<Domanda> listDomande= readFileDomande(fileXML.getPath());
		listDomande.add(domanda);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=null;
        try {
        	builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
		
        Document document = builder.newDocument();
        Element domande = document.createElement("domande");
        document.appendChild(domande);
        
        for (Domanda d: listDomande) {
        	
        	Element dom =document.createElement("domanda");
        	domande.appendChild(dom);
        	
        	dom.setAttribute("id", Integer.toString(d.getId()));
        	dom.setAttribute("book",d.getBook());
        	dom.setAttribute("chapter", Integer.toString(d.getChapter()));
        	dom.setAttribute("question", Integer.toString(d.getQuestion()));
        	
        	Element testo=document.createElement("testo");
        	testo.setTextContent(d.getTesto());
        	dom.appendChild(testo);
        	
        	Element risposte = document.createElement("risposte");        	
        	risposte.setAttribute("type",d.getAnswerType());
        	dom.appendChild(risposte);
        	
        	List <Risposta> listRisposta = d.getRisposte();
        	Element risposta=null;
        	for(Risposta r: listRisposta) {
        		risposta=document.createElement("risposta");
        		risposta.setAttribute("type", r.getValue());
        		risposta.setTextContent(r.getText());
        		risposte.appendChild(risposta);
        	}
        	
        
        	
        	Element risposteEsatte=document.createElement("risposteEsatte");
        	risposteEsatte.setTextContent(d.getRispostaEsatta());
        	dom.appendChild(risposteEsatte);
        	
        	Element spiegazione= document.createElement("spiegazione");
        	spiegazione.setTextContent("spiegazione");
        	dom.appendChild(spiegazione);     	
        	
        }
        
        
        
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer =null;
		try {
		 transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(fileXML);
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		System.out.println("File saved!");

        
	}
	

}
