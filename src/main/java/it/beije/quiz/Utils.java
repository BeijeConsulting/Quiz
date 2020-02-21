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

import it.beije.quiz.model.*;

public class Utils {
	
	
	public static List<File> selezionaFileDiInteresse(String dir){
		
		File file = null;
		List<File> filez = new ArrayList<File>();
		if (dir != null) {
			String path = "C:\\Users\\Padawan13\\git\\Quiz\\domande\\"+ dir;
			int i = 1;
			if(dir.equals("oca_manual")) {
				file = new File(path + "\\domande_Assessment_Test.xml");
				filez.add(file);
			}
			file = new File(path + "\\domande_cap" + i + ".xml");
			
			while (file.exists()) {
				filez.add(file);
				file = new File(path + "\\domande_cap" + (++i) + ".xml");
			}
			
		}
			return filez;
	}
	
	
	public static void caricaFileInteressanti(List<File> filez) {
		
		
	}
	
	
	
	
	
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
	        List<Element> domande = Utils.getChildElements(element);
//	        System.out.println(domande);
	        	        
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
		        List<Risposta> risposte = new ArrayList<Risposta>();
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
//	        	System.out.println(d);
	        }	        		
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayDomande;
	}
	
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****************BRANCH CLARK*****************/
	
	
	//Scrittura (append) della domanda nel file xml gia esistente
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************************/

}
