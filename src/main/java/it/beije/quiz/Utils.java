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

	public static String nuovoId(String dir, int capitolo, int nDomanda) {
		StringBuilder sb = new StringBuilder();
		sb.append(dir).append("|").append(capitolo).append("|").append(nDomanda);
		return sb.toString();
	}
	public static String getDirectory(String id) {
		String[] elementi = id.split("([|])");

		return elementi[0];
	}
	public static int getCapitolo(String id) {
		String[] elementi = id.split("([|])");

		return Integer.parseInt(elementi[1]);
	}
	public static int getNDomanda(String id) {
		String[] elementi = id.split("([|])");

		return Integer.parseInt(elementi[2]);
	}
	public static List<File> selezionaFileDiInteresse(String dir) {

		File file = null;
		List<File> filez = new ArrayList<File>();
		if (dir != null) {
			String path = "C:\\Users\\Padawan07\\git\\Quiz\\domande\\" + dir;
			int i = 1;
			if (dir.equals("oca_manual")) {
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
	public static List<Libro> caricaLibriDaIndexXML(String pathIndexFile) { // TeamClariGa_Ga metodo per parsare
																			// index.xml
		File file = new File(pathIndexFile);
		List<Libro> listaLibri = caricaLibriDaIndexXML(file);

		return listaLibri;
	}
	public static List<Libro> caricaLibriDaIndexXML(File file) {

		List<Libro> listaLibri = new ArrayList<Libro>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(file);

			Element element = document.getDocumentElement();
//	        System.out.println(element.getTagName());	        
			List<Element> libriInXML = Utils.getChildElements(element);

			for (int i = 0; i < libriInXML.size(); i++) {
				Libro libro = new Libro();
				String id_book = libriInXML.get(i).getAttribute("id_book");
				String dir = libriInXML.get(i).getAttribute("dir");
				String title = libriInXML.get(i).getAttribute("title");
				libro.setIdBook(id_book);
				libro.setDir(dir);
				libro.setTitle(title);
				listaLibri.add(libro);
			}

		} catch (Exception e) {
		}
		return listaLibri;
	}
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
	public static void scriviSuXML(List<Libro> libro, String pathfile) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("index");
		document.appendChild(docElement);

		for (Libro l : libro) {
			Element quiz = document.createElement("quiz");
			quiz.setAttribute("id_book", l.getIdBook());
			quiz.setAttribute("title", l.getTitle());
			quiz.setAttribute("dir", l.getDir());

			docElement.appendChild(quiz);
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathfile));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
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
				String id = (domanda.getAttribute("id"));
				String book = domanda.getAttribute("book");
				int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
				int question = Integer.parseInt(domanda.getAttribute("question"));
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

				String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
				String spiegazione = contenutoDomanda.get(3).getTextContent();

				List<Libro> listaLibriInXML = Utils
						.caricaLibriDaIndexXML("C:\\Users\\Padawan07\\git\\Quiz\\domande\\index.xml");

				String dir = null;
				for (Libro l : listaLibriInXML) {
					if (book.equals(l.getTitle())) {
						dir = l.getDir();
						break;
					}
				}

				String nuovoId = nuovoId(dir, chapter, question);

				Domanda d = new Domanda(nuovoId, book, chapter, question, testo, answerType, risposte, rispostaEsatta,
						spiegazione);

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
	public static void aggiungiDomanda(Domanda domanda, File fileXML) {
		List<Domanda> listDomande = new ArrayList<Domanda>();
		listDomande = readFileDomande(fileXML.getPath());
		listDomande.add(domanda);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = builder.newDocument();
		Element domande = document.createElement("domande");
		document.appendChild(domande);

		for (Domanda d : listDomande) {

			Element dom = document.createElement("domanda");
			domande.appendChild(dom);

			dom.setAttribute("id", d.getId());
			dom.setAttribute("book", d.getBook());
			dom.setAttribute("chapter", Integer.toString(d.getChapter()));
			dom.setAttribute("question", Integer.toString(d.getQuestion()));

			Element testo = document.createElement("testo");
			testo.setTextContent(d.getTesto());
			dom.appendChild(testo);

			Element risposte = document.createElement("risposte");
			risposte.setAttribute("type", d.getAnswerType());
			dom.appendChild(risposte);

			List<Risposta> listRisposta = d.getRisposte();
			Element risposta = null;
			for (Risposta r : listRisposta) {
				risposta = document.createElement("risposta");
				risposta.setAttribute("value", r.getValue());
				risposta.setTextContent(r.getText());
				risposte.appendChild(risposta);
			}

			Element risposteEsatte = document.createElement("risposteEsatte");
			risposteEsatte.setTextContent(d.getRispostaEsatta());
			dom.appendChild(risposteEsatte);

			Element spiegazione = document.createElement("spiegazione");
			spiegazione.setTextContent(d.getSpiegazione());
			dom.appendChild(spiegazione);

		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
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
	public static void eliminaDomanda(Domanda domanda, File fileXML) {
		List<Domanda> listDomande = new ArrayList<Domanda>();
		listDomande = readFileDomande(fileXML.getPath());
		List<Domanda> prova = new ArrayList<Domanda>();

		for (Domanda dom : listDomande) {
			if (!dom.getId().equals(domanda.getId())) {
				prova.add(dom);
			}
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document document = builder.newDocument();
		Element domande = document.createElement("domande");
		document.appendChild(domande);

		for (Domanda d : prova) {

			Element dom = document.createElement("domanda");
			domande.appendChild(dom);

			dom.setAttribute("id", d.getId());
			dom.setAttribute("book", d.getBook());
			dom.setAttribute("chapter", Integer.toString(d.getChapter()));
			dom.setAttribute("question", Integer.toString(d.getQuestion()));

			Element testo = document.createElement("testo");
			testo.setTextContent(d.getTesto());
			dom.appendChild(testo);

			Element risposte = document.createElement("risposte");
			risposte.setAttribute("type", d.getAnswerType());
			dom.appendChild(risposte);

			List<Risposta> listRisposta = d.getRisposte();
			Element risposta = null;
			for (Risposta r : listRisposta) {
				risposta = document.createElement("risposta");
				risposta.setAttribute("value", r.getValue());
				risposta.setTextContent(r.getText());
				risposte.appendChild(risposta);
			}

			Element risposteEsatte = document.createElement("risposteEsatte");
			risposteEsatte.setTextContent(d.getRispostaEsatta());
			dom.appendChild(risposteEsatte);

			Element spiegazione = document.createElement("spiegazione");
			spiegazione.setTextContent(d.getSpiegazione());
			dom.appendChild(spiegazione);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
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
}

