package it.beije.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {
	
	/*
	 * metodo richiamato dal readFileDomande per ottenere i vari elementi dei nodi scritti sull'xml
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

	public static String[] listFileNames(File dir) {
		String[] fileNames = dir.list();
		for(int i = 0; i<fileNames.length; i++) {
			fileNames[i] = fileNames[i].replace(".xml", "");
		}
		return fileNames;
	}
	
	/*
	 * formatta il testo da caratteri java a html in quanto l'accapo e il tab valgono sempre come
	 * un singolo spazio su html
	 */
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
	
	/*
	 * controlla risposta per risposta, controllando se è presente la lettera corrispondente alla 
	 * risposta corretta. C'era il problema delle risposteEsatte scritte con la virgola, risolto
	 * con un semplice replace
	 */
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		rispostaEsatta = rispostaEsatta.replaceAll(" ", "");
		rispostaEsatta = rispostaEsatta.replaceAll(",", "");
		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (rispostaEsatta.indexOf(c) < 0) {
				return false;//se non trovo la risposta termino il ciclo
			} else {
				//tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		
		return rispostaEsatta.length() == 0;
	}

}
