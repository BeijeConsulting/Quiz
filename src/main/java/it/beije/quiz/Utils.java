package it.beije.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;

public class Utils {
	
	public static final String PATH_INDEX_BOOKS = Libro.LIB_PATH+"index.xml";
	
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
	
	public static List<Libro> readFileLibri() {
		List<Libro> elencoLibri = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        Document document = builder.parse(new File(PATH_INDEX_BOOKS));
	        Element element = document.getDocumentElement();	        

	        List<Element> elementLibri = Utils.getChildElements(element);
	        for(Element e : elementLibri) {
	        	Libro l = new Libro();
	        	l.setIdBook(e.getAttribute("id_book"));
	        	l.setTitle(e.getAttribute("title"));
	        	l.setNameDir(e.getAttribute("dir"));
	        	elencoLibri.add(l);
	        }
	     
		}catch(Exception e) {
			e.printStackTrace();
		}
		return elencoLibri;
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
	        	String id_ = domanda.getAttribute("id");
		        String book = domanda.getAttribute("book");
		        int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
		        int question = Integer.parseInt(domanda.getAttribute("question"));
		        String testo = contenutoDomanda.get(0).getTextContent();
		        String id = generateId(chapter, question, book);
		        
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
	
	public static String generateId(int chapter, int question, String book) {
		
		String id="";
		
		//List<Libro> libri= readFileLibri();
		List<Libro> libri= new ArrayList<Libro>();
		
		for (Libro l : libri) if (book.contentEquals(l.getTitle())) id=l.getIdBook()+chapter+question;
		
		return id;
	}
	
	private static Libro createLibro(Libro l) {	 
		
        for(Libro presente : readFileLibri()) {
        	if(presente.getIdBook().equals(l.getIdBook()) && presente.getNameDir().equals(l.getNameDir())
        			&& presente.getTitle().equals(l.getTitle())) 
        		return presente;
        	if(presente.getIdBook().equals(l.getIdBook()) || presente.getNameDir().equals(l.getNameDir())) 
        		return null;
        }
        //crea una nuova directory
		File file = new File(Libro.LIB_PATH+l.getNameDir());
		if(!file.mkdir()) return null;
		
		//scrive su index.xml
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        File fileIndex = new File(PATH_INDEX_BOOKS);
	        Document document = builder.parse(fileIndex);
	        Element docElement = document.getDocumentElement();
	        Element elLibro = document.createElement("quiz");
	        elLibro.setAttribute("id_book", l.getIdBook());
	        elLibro.setAttribute("title", l.getTitle());
	        elLibro.setAttribute("dir", l.getNameDir());
	        docElement.appendChild(elLibro);
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(fileIndex);
			transformer.transform(source, result);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
		return l;
	}
	
	public static void caricaDomande(Libro l, List<Domanda> elDomande, String nomeFile) {
		
		try {
			l = createLibro(l);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        File file = new File(Libro.LIB_PATH+l.getNameDir()+"\\"+nomeFile);
	        Document document;
	        Element docElement;
			
	        if(file.exists()) {
				document = builder.parse(file);
		        docElement = document.getDocumentElement();
			}else {
				document = builder.newDocument();
		        docElement = document.createElement("domande");
		        document.appendChild(docElement);
			}
	        
	        for(Domanda d : elDomande) {
	        	Element domanda = document.createElement("domanda");
	        	domanda.setAttribute("id", d.getId());
	        	domanda.setAttribute("book", d.getBook());
	        	domanda.setAttribute("chapter", d.getChapter()+"");
	        	domanda.setAttribute("question", d.getQuestion()+"");
	        	docElement.appendChild(domanda);
	        	
	        	Element testo = document.createElement("testo");
	        	testo.setTextContent(d.getTesto());
	        	domanda.appendChild(testo);
	        	
	        	Element risposte = document.createElement("risposte");
	        	risposte.setAttribute("type", d.getAnswerType());
	        	for(Risposta r : d.getRisposte()) {
	        		Element risposta = document.createElement("risposta");
	        		risposte.setAttribute("value", r.getValue());
	        		risposte.setTextContent(r.getText());
	        		risposte.appendChild(risposta);
	        	}
	        	domanda.appendChild(risposte);
	        	
	        	Element risposteEsatte = document.createElement("risposteEsatte");
	        	risposteEsatte.setTextContent(d.getRispostaEsatta());
	        	domanda.appendChild(risposteEsatte);
	        	
	        	Element spiegazione = document.createElement("spiegazione");
	        	spiegazione.setTextContent(d.getSpiegazione());
	        	domanda.appendChild(spiegazione);
	        }
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}catch(NullPointerException e) {
			System.out.println("Errore nella creazione della directory");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
