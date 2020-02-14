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

public class Utils 
{
	
	public static List<Element> getChildElements(Element element) //Metodo dinamico che prende l'elemento (quello che c'è tra due tag) e lo inserisce in un ArrayList di elementi
	{ 
		List<Element> childElements = new ArrayList<Element>();
		
		NodeList nodeList = element.getChildNodes(); //Estrapola i nodi figli (il nodo è il tag principali, i nodi figli sono i contenuti degli altri tag)
        Node node = null;
        for (int i = 0; i < nodeList.getLength(); i++)
        {
        	node = nodeList.item(i);
        	if (node.getNodeType() == Node.ELEMENT_NODE) //Ciascun nodo viene inserito nell'ArrayList verificando che sia del tipo corretto
        	{ 
        		childElements.add((Element)node);
        	}
        }
		
		return childElements; //Restituisce così l'ArrayList elementi figli creati.
	}

	public static List<Domanda> readFileDomande(String pathFile)
	{
		List<Domanda> arrayDomande = new ArrayList<Domanda>(); //Un ArrayList di Domande
		
		try 
		{ //Leggo il file XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(new File(pathFile));
	        Element element = document.getDocumentElement();	        
//	        System.out.println(element.getTagName());
	        List<Element> domande = Utils.getChildElements(element); //Richiamo il metodo che mi inserisce gli elementi nell'ArrayList domande
//	        System.out.println(domande);
	        	        
	        List<Element> contenutoDomanda = null;
	        List<Element> elementiRisposta = null;
	        Element rispostePossibili = null;
	        for (Element domanda : domande)
	        {
	        	contenutoDomanda = Utils.getChildElements(domanda); //Ciascun elemento di domande viene controllato e il contenuto salvato in contenutoDomanda
		        int id = Integer.parseInt(domanda.getAttribute("id")); //Salvo ID
		        String book = domanda.getAttribute("book"); //Nome libro
		        int chapter = Integer.parseInt(domanda.getAttribute("chapter")); //Capitolo
		        int question = Integer.parseInt(domanda.getAttribute("question")); //Conenuto della domanda
		        String testo = contenutoDomanda.get(0).getTextContent(); //contenutoDomanda contiene i nodi figli di domanda e il primo elemento è sempre il testo che viene memorizzato nella stringa testo
		        
		        //caricare le risposte possibili
		        rispostePossibili = contenutoDomanda.get(1); //La prima parte del file XML, e cioè il contenuto, viene inserito come Element sull'oggetto rispostePossibili
		        String answerType = rispostePossibili.getAttribute("type"); //Inserisce all'interno della stringa answerType le opazioni di risposta 
		        elementiRisposta = Utils.getChildElements(rispostePossibili); //Sull'ArrayList elementiRisposta inserisce le risposte sotto forma di elementi
		        List<Risposta> risposte = new ArrayList<Risposta>();
		        for (Element risposta : elementiRisposta) //Sull'ArrayList risposte vengono inserite le risposte sotto forma di value ABC
		        {
		        	Risposta r = new Risposta();
		        	r.setValue(risposta.getAttribute("value"));
		        	r.setText(risposta.getTextContent());
		        	
		        	risposte.add(r);
		        }
		        
		        String rispostaEsatta = contenutoDomanda.get(2).getTextContent(); //Risposta esatta
		        String spiegazione = contenutoDomanda.get(3).getTextContent();
		        
	        	Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta, spiegazione);
	        	arrayDomande.add(d);
	        	
//	        	System.out.println(d);
	        }	        		
	        
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return arrayDomande;
	}
	
	public static String formattaTesto(String testo)
	{
		if (testo != null && testo.length() > 0)
		{
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		
		return testo;
	}
	
	public static boolean controllaRisposta(String rispostaEsatta, String risposta)
	{
		for (int i = 0; i < risposta.length(); i++)
		{
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
			if (rispostaEsatta.indexOf(c) < 0)
			{
				return false;//se non trovo la risposta termino il ciclo
			} 
			else
			{
				//tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		
		return rispostaEsatta.length() == 0;
	}

}
