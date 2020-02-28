package it.beije.quiz;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.jdt.internal.compiler.apt.util.EclipseFileManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;

public class Utils {

	public static List<Element> getChildElements(Element element) {
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

	public static List<Domanda> readFileDomande(String pathFile, String dir) {
		List<Domanda> arrayDomande = new ArrayList<Domanda>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Load the input XML document, parse it and return an instance of the
			// Document class.
			File f = new File(pathFile);
			Document document = builder.parse(f);
			Element element = document.getDocumentElement();
//	        System.out.println(element.getTagName());
			List<Element> domande = Utils.getChildElements(element);
//	        System.out.println(domande);

			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;
			for (Element domanda : domande) {
				contenutoDomanda = Utils.getChildElements(domanda);
				
				String book = domanda.getAttribute("book");
				String chapter = domanda.getAttribute("chapter");
				String question = domanda.getAttribute("question");
				String testo = contenutoDomanda.get(0).getTextContent();
				String id = dir + "|" + chapter + "|" + question;
				System.out.println("ID: " + id);

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

				String rispostaEsatta = contenutoDomanda.get(2).getTextContent().replace(" ", "").replace(",", "");

				String spiegazione = contenutoDomanda.get(3).getTextContent();

				Domanda d = new Domanda(id, book, chapter, question, testo, answerType, risposte, rispostaEsatta,
						spiegazione);
				arrayDomande.add(d);

//	        	System.out.println(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayDomande;
	}

	public static void writeDomandeXML(Domanda domanda, String pathfile) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File f = new File(pathfile);
		Document document = null;
		Element domandaradice = null;
		
		if(f.exists()) {
			document = builder.parse(f);
			domandaradice = document.getDocumentElement();
		} else {
			document = builder.newDocument();  // creazione nuovo documento XML
			domandaradice = document.createElement("domande");
		}
	
		Element domandaxml = document.createElement("domanda"); // creazione elemento radice 
		domandaxml.setAttribute("id", domanda.getId());
		domandaxml.setAttribute("book", domanda.getBook());
		domandaxml.setAttribute("chapter", domanda.getChapter());
		domandaxml.setAttribute("question", domanda.getQuestion());
		
		Element testoxml = document.createElement("testo");
		testoxml.setTextContent(domanda.getTesto());
		domandaxml.appendChild(testoxml);
		
		Element risposte = document.createElement("risposte");
		risposte.setAttribute("type", domanda.getAnswerType());
		System.out.println("Get Domande:" + domanda.getRisposte());
		for (Risposta r : domanda.getRisposte()) {
			Element rispostaxml = document.createElement("risposta");
			rispostaxml.setAttribute("value", r.getValue());
			rispostaxml.setTextContent(r.getText());
			risposte.appendChild(rispostaxml);
		}
		
		domandaxml.appendChild(risposte);
		domandaradice.appendChild(domandaxml);
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(pathfile);

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}

	// Lettura file index.xml e popolamento lista di Libro
	public static List<Libro> getLibri() throws ParserConfigurationException, SAXException, IOException {

		File fileXml = new File("C:\\Users\\Padawan04\\git\\Quiz\\domande\\index.xml");

		String filePath = new File("").getAbsolutePath();
		System.out.println("File: " + filePath);

		List<Libro> libri = new ArrayList<Libro>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(fileXml);
		Element element = document.getDocumentElement();

		NodeList nodeLibri = element.getElementsByTagName("quiz");

		for (int i = 0; i < nodeLibri.getLength(); i++) {
			Libro lib = new Libro();
			Element libro = (Element) nodeLibri.item(i);
			lib.setDir((String) libro.getAttribute("dir"));
			lib.setTitle((String) libro.getAttribute("title"));
			lib.setId_book((String) libro.getAttribute("id_book"));
			libri.add(lib);
		}
//        System.out.println("libri : " + libri.size());

		return libri;
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
