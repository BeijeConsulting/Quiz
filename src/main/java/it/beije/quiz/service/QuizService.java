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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;

@Service
public class QuizService {
	
	private final String MAIN_PATH = "C:\\Users\\Beijeù\\git\\Quiz\\domande\\";
	public final String PATH_INDEX_BOOKS = MAIN_PATH +"index.xml";

	public List<Domanda> getLibriCarichi(Libro l){
		System.out.println("inizio passaggio");
		List<Domanda> domande= new ArrayList<>();
		try {		

			File folder = new File(MAIN_PATH + l.getNameDir());

			for (final File fileEntry : folder.listFiles()) {
				System.out.println("caricoooo");
				domande.addAll(readFileDomande(folder + "\\" + fileEntry.getName()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return domande;
	}
	
	public List<Element> getChildElements(Element element) {
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

	public List<Libro> caricaLibri(File file) throws ParserConfigurationException, SAXException, IOException {
		List<Libro> lista = new ArrayList<Libro>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();


		Document document = builder.parse(file);
		Element element = document.getDocumentElement();     

		List<Element> elementi = getChildElements(element);


		for(int i=0;i<elementi.size();i++)
		{
			Libro libro = new Libro();
			libro.setIdBook(elementi.get(i).getAttribute("id_book"));
			libro.setTitle(elementi.get(i).getAttribute("title"));
			libro.setNameDir(elementi.get(i).getAttribute("dir"));

			lista.add(libro);
		}

		return lista;

	}

	public List<Libro> readFileLibri() {
		List<Libro> elencoLibri = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File(PATH_INDEX_BOOKS));
			Element element = document.getDocumentElement();	        

			List<Element> elementLibri = getChildElements(element);
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

	public List<Domanda> readFileDomande(String pathFile) {

		List<Domanda> arrayDomande = new ArrayList<Domanda>();



		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Load the input XML document, parse it and return an instance of the
			// Document class.
			Document document = builder.parse(new File(pathFile));
			Element element = document.getDocumentElement();
			//	 	        System.out.println(element.getTagName());
			List<Element> domande = getChildElements(element);
			//	 	        System.out.println(domande);

			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;
			for (Element domanda : domande) {

				contenutoDomanda = getChildElements(domanda);
				String book = domanda.getAttribute("book");
				String chapter = (domanda.getAttribute("chapter"));
				String question = (domanda.getAttribute("question"));
				String testo = contenutoDomanda.get(0).getTextContent();

				// caricare le risposte possibili
				rispostePossibili = contenutoDomanda.get(1);
				String answerType = rispostePossibili.getAttribute("type");
				elementiRisposta = getChildElements(rispostePossibili);
				List<Risposta> risposte = new ArrayList<Risposta>();
				for (Element risposta : elementiRisposta) {
					Risposta r = new Risposta();
					r.setValue(risposta.getAttribute("value"));
					r.setText(risposta.getTextContent());

					risposte.add(r);
				}
				String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
				String spiegazione = contenutoDomanda.get(3).getTextContent();

				Domanda d = new Domanda(generateId(chapter,question, book), book, chapter, question, testo, answerType, risposte, rispostaEsatta,
						spiegazione);

				arrayDomande.add(d);

			}

		} catch (Exception e) {
			System.out.println("eccezione");
			e.printStackTrace();
		}

		System.out.println("return arrivo");
		return arrayDomande;
	}

	public String generateId(String chapter, String question, String book) {

		String id="";

		List<Libro> libri= readFileLibri();

		for (Libro l : libri) if (book.contentEquals(l.getTitle())) id=l.getIdBook()+"-"+chapter+"-"+question;


		return id;
	}

	public Libro createLibro(Libro l) {	 

		for(Libro presente : readFileLibri()) {
			if(presente.getIdBook().equals(l.getIdBook()) && presente.getNameDir().equals(l.getNameDir())
					&& presente.getTitle().equals(l.getTitle())) 
				return presente;
			if(presente.getIdBook().equals(l.getIdBook()) || presente.getNameDir().equals(l.getNameDir())) 
				return null;
		}
		//crea una nuova directory
		File file = new File(MAIN_PATH+l.getNameDir());
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

	public String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}

		return testo;
	}
	
	public String generateNomeFile(Domanda domanda) {
		int nCap = Integer.parseInt(domanda.getChapter());

		return "domande_cap"+nCap;
	}

	public void caricaDomande(Libro l, List<Domanda> elDomande) {

		try {
			l = createLibro(l);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(MAIN_PATH+l.getNameDir()+"\\"+generateNomeFile(elDomande.get(0))+".xml");
			Document document;
			Element docElement;
			int idDomanda = 1;
			
			if(file.exists()) {

				document = builder.parse(file);
				docElement = document.getDocumentElement();
				List<Element> dom = getChildElements(docElement);
				idDomanda = Integer.parseInt(dom.get(dom.size()-1).getAttribute("id")) +1;
				//ulteriore controllo
				for(Element e : dom) {
					if(Integer.parseInt(e.getAttribute("id"))==idDomanda) idDomanda++;
				}
			}else {
				document = builder.newDocument();
				docElement = document.createElement("domande");
				document.appendChild(docElement);
			}

			for(Domanda d : elDomande) {
				Element domanda = document.createElement("domanda");
				domanda.setAttribute("id", idDomanda+"");
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
		}catch(NullPointerException e) {
			System.out.println("Errore nella creazione della directory");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void ricaricaDomande(Libro l, List<Domanda> elDomande) {

		try {
			l = createLibro(l);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(MAIN_PATH+l.getNameDir()+"\\"+generateNomeFile(elDomande.get(0))+".xml");
			Document document;
			Element docElement;
			int idDomanda = 1;
			
			document = builder.newDocument();
			docElement = document.createElement("domande");
			document.appendChild(docElement);
			

			for(Domanda d : elDomande) {
				Element domanda = document.createElement("domanda");
				domanda.setAttribute("id", idDomanda+"");
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
				idDomanda++;
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

	public boolean controllaRisposta(String rispostaEsatta, String risposta) {
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
