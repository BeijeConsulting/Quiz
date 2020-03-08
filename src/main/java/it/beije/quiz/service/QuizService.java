package it.beije.quiz.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;

@Service
public class QuizService {

	public static final String BASE_DIRECTORY = "C:\\Users\\" + System.getProperty("user.name")
			+ "\\git\\Quiz\\domande\\"; // directory globale al cui interno stanno i libri.

	public static final String BASE_DIRECTORY_INDEX = BASE_DIRECTORY + "index.xml"; // file xml contenente i libri

	public QuizService() {
		System.out.println("Creo istanza di QuizService"); // Debug

	}

	private List<Domanda> listaDomande = null;

	private void caricaDomande() { // (PRIVATO)Metodo che carica le domande di tutta la directory \\domande, quindi
									// tutte le domande di tutti i libri
		listaDomande = new ArrayList<Domanda>();
		File directoryDomande = new File(BASE_DIRECTORY);
		String dir = "";
		for (File file : directoryDomande.listFiles()) {

			if (file.isDirectory()) {
				dir = file.getName();
				for (File ff : file.listFiles()) {
					listaDomande.addAll(readFileDomande(ff.getAbsolutePath(), dir));
				}
			}
		}
	}

	public List<Domanda> getDomande() { // metodo che permette di istanziare una sola volta tutte le domande presenti
										// nella directory \\domande.
		if (listaDomande == null) {
			caricaDomande();
		}

		return listaDomande;
	}

	// LEGGE TUTTE LE DOMANDE
	public List<Domanda> readFileDomande(String pathFile, String dir) {
		System.out.println("readFileDomande..."); // Debug
		List<Domanda> arrayDomande = new ArrayList<Domanda>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			File f = new File(pathFile);
			Document document = builder.parse(f);
			Element element = document.getDocumentElement();
			List<Element> domande = Utils.getChildElements(element);

			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;
			for (Element domanda : domande) {
				contenutoDomanda = Utils.getChildElements(domanda);

				String book = domanda.getAttribute("book");
				String chapter = domanda.getAttribute("chapter");
				int question = Integer.parseInt(domanda.getAttribute("question"));
				String testo = contenutoDomanda.get(0).getTextContent();
				String id = dir + "|" + chapter + "|" + question; // modifico in runtime l'id.
				// System.out.println("ID: " + id); // Debug

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

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayDomande;
	}

	public boolean eliminaDomandaInXML(Domanda PresenteNelXML) throws Exception {

		StringBuilder path = new StringBuilder();
		/************
		 * LOCALIZZO FILE CONTENENTE LA DOMANDA DA ELIMINARE
		 ***********************/
		String capitolo = Utils.isNumber(PresenteNelXML.getChapter()) ? "domande_cap" + PresenteNelXML.getChapter()
				: "domanda_" + PresenteNelXML.getChapter();
		path.append(BASE_DIRECTORY).append(Utils.getDirectoryFromDomanda(PresenteNelXML)).append("\\").append(capitolo)
				.append(".xml");

		System.out.println("Debug QuizService:...:...:...:...:..:" + path.toString());

		/************************************************************************************/

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File file = new File(path.toString());

		Document document = builder.parse(file);
		Element element = document.getDocumentElement(); // rootElem domande
		List<Element> domande = Utils.getChildElements(element); // domanda per domanda. lista di elementi

		for (int i = 0; i < domande.size(); i++) {
			Element domanda = domande.get(i);
			if (domanda.getAttribute("book").equals(PresenteNelXML.getBook())) {
				System.out.println("domanda.getAttribute(\"book\").equals(PresenteNelXML.getBook()) TRUE TRUE TRUE");
				if (domanda.getAttribute("chapter").equals(PresenteNelXML.getChapter())) {
					System.out.println(
							"domanda.getAttribute(\"chapter\").equals(PresenteNelXML.getChapter()) TRUE TRUE TRUE");
					if (domanda.getAttribute("question").equals(String.valueOf(PresenteNelXML.getQuestion()))) {
						System.out.println(
								"domanda.getAttribute(\"question\").equals(String.valueOf(PresenteNelXML.getQuestion())) TRUE TRUE TRUE");
						Node parent = domanda.getParentNode();
						parent.removeChild(domanda);
						parent.normalize();
						caricaDomande();
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean aggiornaDomandaInXML(Domanda domandaNuova) throws Exception {

		StringBuilder path = new StringBuilder();

		String capitolo = Utils.isNumber(domandaNuova.getChapter()) ? "domande_cap" + domandaNuova.getChapter()
				: "domanda_" + domandaNuova.getChapter();
		path.append(BASE_DIRECTORY).append(Utils.getDirectoryFromDomanda(domandaNuova)).append("\\").append(capitolo)
				.append(".xml");
		System.out.println("Debug QuizService:...:...:...:...:..:" + path.toString());

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File f = new File(path.toString());

		Document document = builder.parse(f);
		Element element = document.getDocumentElement();
		List<Element> domande = Utils.getChildElements(element);

		List<Element> contenutoDomanda = null;
		List<Element> elementiRisposta = null;
		Element rispostePossibili = null;
		for (Element domanda : domande) {
			System.out.println("sovrascrivo parametri in XML..");
			contenutoDomanda = Utils.getChildElements(domanda);
			domanda.setAttribute("id", domandaNuova.getId());
			domanda.setAttribute("book", domandaNuova.getBook());
			domanda.setAttribute("chapter", domandaNuova.getChapter());
			domanda.setAttribute("question", String.valueOf(domandaNuova.getQuestion()));

			contenutoDomanda.get(0).setTextContent(domandaNuova.getTesto());

			rispostePossibili = contenutoDomanda.get(1);

			rispostePossibili.setTextContent(domandaNuova.getRispostaUtente());
			rispostePossibili.setAttribute("type", domandaNuova.getAnswerType());
			elementiRisposta = Utils.getChildElements(rispostePossibili);
			int lengthRisposte = elementiRisposta.size();
			// caricare le risposte possibili
			List<Risposta> risposte = new ArrayList<Risposta>();
			for (int i = 0; i < lengthRisposte; i++) {
				Risposta r = new Risposta();
				Element risposta = elementiRisposta.get(i);
				String attrValue = domandaNuova.getRisposte().get(i).getValue(); // attr
				String textContent = domandaNuova.getRisposte().get(i).getText(); // txtContent
				risposta.setAttribute("value", attrValue);
				risposta.setTextContent(textContent);

				r.setValue(attrValue);
				r.setText(textContent);

				risposte.add(r);
			}

			contenutoDomanda.get(2).setTextContent(domandaNuova.getRispostaEsatta());
			// String rispostaEsatta = contenutoDomanda.get(2).getTextContent().replace(" ",
			// "").replace(",", "");

			contenutoDomanda.get(3).setTextContent(domandaNuova.getSpiegazione());
			// String spiegazione = contenutoDomanda.get(3).getTextContent();
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(path.toString());

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File Updated!");
			int sizeDomandePrima = listaDomande.size();
			caricaDomande();
			int sizeDomandeDopo = listaDomande.size();
			if (sizeDomandePrima != sizeDomandeDopo) {
				return true;
			}
		}
		return false;

	}

	public Libro parseLib(String titoloLibro) { // ___07032020___GAB__vede se esista libro altrimento lo crea.
		List<Libro> listaLibriInIndex = leggiLibriInIndexXML();
		Libro libroz = new Libro();
		for (Libro lib : listaLibriInIndex) {
			if (lib.getNameDir().equals(titoloLibro)) { // libro c'è già in index. quindi ritorno quel libro.
				libroz = lib;
				return libroz;
			}
		}

		libroz.setNameDir(titoloLibro);
		libroz.setIdBook(titoloLibro);
		libroz.setTitle(titoloLibro);
		createLibro(libroz); // lo mette in index se non c'era già.
		return libroz;

	}

	public void writeDomandeXML(Domanda domanda, String pathfile) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File f = new File(pathfile);
		Document document = null;
		Element domandaradice = null;

		System.out.println("Get book: " + domanda.getBook());

		if (f.exists()) {
			document = builder.parse(f);
			domandaradice = document.getDocumentElement();
		} else {
			document = builder.newDocument(); // creazione nuovo documento XML
			domandaradice = document.createElement("domande");
		}

		Element domandaxml = document.createElement("domanda"); // creazione elemento radice
		domandaxml.setAttribute("id", domanda.getId());
		domandaxml.setAttribute("book", domanda.getBook());
		domandaxml.setAttribute("chapter", domanda.getChapter());
		domandaxml.setAttribute("question", String.valueOf(domanda.getQuestion()));

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

		Element rispOk = document.createElement("risposteEsatte");
		rispOk.setTextContent(domanda.getRispostaEsatta());

		domandaxml.appendChild(risposte);
		domandaxml.appendChild(rispOk);

		Element spiegazione = document.createElement("spiegazione");
		spiegazione.setTextContent(domanda.getSpiegazione());
		domandaxml.appendChild(spiegazione);

		domandaradice.appendChild(domandaxml);

		if (!f.exists()) {
			document.appendChild(domandaradice);
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = null;
		if (f.exists()) {
			result = new StreamResult(pathfile);
		} else {
			result = new StreamResult(new File(pathfile));
		}
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}

	public List<Libro> leggiLibriInIndexXML() {
		List<Libro> elencoLibri = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File(BASE_DIRECTORY_INDEX));
			Element element = document.getDocumentElement();

			List<Element> elementLibri = Utils.getChildElements(element);
			for (Element e : elementLibri) {
				Libro l = new Libro();
				l.setIdBook(e.getAttribute("id_book"));
				l.setTitle(e.getAttribute("title"));
				l.setNameDir(e.getAttribute("dir"));
				elencoLibri.add(l);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return elencoLibri;
	}

	public Libro createLibro(Libro libro) {

		for (Libro presente : leggiLibriInIndexXML()) {
			if (presente.getIdBook().equals(libro.getIdBook()) && presente.getNameDir().equals(libro.getNameDir())
					&& presente.getTitle().equals(libro.getTitle()))
				return presente;
			if (presente.getIdBook().equals(libro.getIdBook()) || presente.getNameDir().equals(libro.getNameDir()))
				return null;
		}
		// crea una nuova directory
		File file = new File(BASE_DIRECTORY + libro.getNameDir());
		if (!file.mkdir())
			return null;

		// scrive su index.xml
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File fileIndex = new File(BASE_DIRECTORY_INDEX);
			Document document = builder.parse(fileIndex);
			Element docElement = document.getDocumentElement();
			Element elLibro = document.createElement("quiz");
			elLibro.setAttribute("id_book", libro.getIdBook());
			elLibro.setAttribute("title", libro.getTitle());
			elLibro.setAttribute("dir", libro.getNameDir());
			docElement.appendChild(elLibro);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(fileIndex);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return libro;
	}

	public boolean caricaDomande(Libro libro, String nomeFile, Domanda... elDomande) {

		try {
			libro = createLibro(libro);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(BASE_DIRECTORY + libro.getNameDir() + "\\" + nomeFile + ".xml");
			Document document;
			Element docElement;
			int idDomanda = 1;
			if (file.exists()) {

				document = builder.parse(file);
				docElement = document.getDocumentElement();
				List<Element> dom = Utils.getChildElements(docElement);
				idDomanda = Integer.parseInt(dom.get(dom.size() - 1).getAttribute("id")) + 1;
				// ulteriore controllo
				for (Element e : dom) {
					if (Integer.parseInt(e.getAttribute("id")) == idDomanda)
						idDomanda++;
				}
			} else {
				document = builder.newDocument();
				docElement = document.createElement("domande");
				document.appendChild(docElement);
			}

			for (Domanda d : elDomande) {
				Element domanda = document.createElement("domanda");
				domanda.setAttribute("id", idDomanda + "");
				domanda.setAttribute("book", d.getBook());
				domanda.setAttribute("chapter", d.getChapter() + "");
				domanda.setAttribute("question", d.getQuestion() + "");
				docElement.appendChild(domanda);

				Element testo = document.createElement("testo");
				testo.setTextContent(d.getTesto());
				domanda.appendChild(testo);

				Element risposte = document.createElement("risposte");
				risposte.setAttribute("type", d.getAnswerType());
				for (Risposta r : d.getRisposte()) {
					Element risposta = document.createElement("risposta");
					risposta.setAttribute("value", r.getValue());
					risposta.setTextContent(r.getText());
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
			return true;
		} catch (NullPointerException e) {
			System.out.println("Errore nella creazione della directory");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void eliminaDomandaXML(Domanda domanda) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String directoryDom = Utils.getDirectoryFromDomanda(domanda);
		String capitolo = Utils.isNumber(domanda.getChapter()) ? "domande_cap" + domanda.getChapter()
				: "domanda_" + domanda.getChapter();
		File file = new File(BASE_DIRECTORY + directoryDom + "\\" + capitolo + ".xml");
		System.out.println("DEbug eliminaDomandaXML riga 381:" + file);
		Document document = null;
		Element docElement = null;
		try {
			document = builder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("riga392--Elimina--..........idDomanada.........:" + domanda.getId());
		
		docElement = document.getElementById(domanda.getId());
		System.out.println("docElem 392 elimina:-----------" + docElement);
		document.removeChild(docElement);
	}

	/* SCREMA LISTA DOMANDE IN BASE LIBRO, CAPITOLO O QUESTION */
	public static List<Domanda> domandeLibro(List<Domanda> listaDomande, String libro) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {//
			if (d.getId().contains(libro + "|")) {
				lista.add(d);
			}
		}
		return lista;
	}

	public static List<Domanda> domandeCapitolo(List<Domanda> listaDomande, String capitolo) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {
			if (d.getChapter().equals(capitolo)) {
				lista.add(d);
			}
		}
		return lista;
	}

	public static List<Domanda> domandeQuestion(List<Domanda> listaDomande, String question) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {
			if (String.valueOf(d.getQuestion()).equals(question)) {
				lista.add(d);
			}
		}
		return lista;
	}
	/*-------------------------------------------------------*/
}
