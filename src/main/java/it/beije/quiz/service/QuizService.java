package it.beije.quiz.service;

import java.io.File;
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

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.model.Risposta;

@Service
public class QuizService {
	
	public static final String BASE_DIRECTORY = "C:\\Users\\" + System.getProperty("user.name") +"\\git\\Quiz\\domande\\"; //directory globale al cui interno stanno i libri.
	
	public static final String BASE_DIRECTORY_INDEX = BASE_DIRECTORY + "index.xml";  //file xml contenente i libri 

	public QuizService() {
		System.out.println("Creo istanza di QuizService"); //Debug
		
	}	

	
	private List<Domanda> listaDomande = null;

	
	private void caricaDomande() { //(PRIVATO)Metodo che carica le domande di tutta la directory \\domande, quindi tutte le domande di tutti i libri
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

	
	public List<Domanda> getDomande() { //metodo che permette di istanziare una sola volta tutte le domande presenti nella directory \\domande.
		if (listaDomande == null) {
			caricaDomande();
		}

		return listaDomande;
	}
	
	
	//LEGGE TUTTE LE DOMANDE 
	public List<Domanda> readFileDomande(String pathFile, String dir) {
		System.out.println("readFileDomande...");
		List<Domanda> arrayDomande = new ArrayList<Domanda>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			
			File f = new File(pathFile);
			Document document = builder.parse(f);
			Element element = document.getDocumentElement();
			// System.out.println(element.getTagName());
			List<Element> domande = Utils.getChildElements(element);
			// System.out.println(domande);

			List<Element> contenutoDomanda = null;
			List<Element> elementiRisposta = null;
			Element rispostePossibili = null;
			for (Element domanda : domande) {
				contenutoDomanda = Utils.getChildElements(domanda);

				String book = domanda.getAttribute("book");
				String chapter = domanda.getAttribute("chapter");
				int question = Integer.parseInt(domanda.getAttribute("question"));
				String testo = contenutoDomanda.get(0).getTextContent();
				String id = dir + "|" + chapter + "|" + question; //modifico in runtime l'id.
				System.out.println("ID: " + id); //Debug

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

				// System.out.println(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayDomande;
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

	
	public  List<Libro> leggiLibriInIndexXML() {
		List<Libro> elencoLibri = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        Document document = builder.parse(new File(BASE_DIRECTORY_INDEX));
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
	
	
	public Libro createLibro(Libro l) {	 
		
        for(Libro presente : leggiLibriInIndexXML()) {
        	if(presente.getIdBook().equals(l.getIdBook()) && presente.getNameDir().equals(l.getNameDir())
        			&& presente.getTitle().equals(l.getTitle())) 
        		return presente;
        	if(presente.getIdBook().equals(l.getIdBook()) || presente.getNameDir().equals(l.getNameDir())) 
        		return null;
        }
        //crea una nuova directory
		File file = new File(BASE_DIRECTORY+l.getNameDir());
		if(!file.mkdir()) return null;
		
		//scrive su index.xml
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        File fileIndex = new File(BASE_DIRECTORY_INDEX);
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
	
	
	public  void caricaDomande(Libro l, String nomeFile, Domanda... elDomande) {
		
		try {
			l = createLibro(l);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        File file = new File(BASE_DIRECTORY +l.getNameDir()+"\\"+nomeFile+".xml");
	        Document document;
	        Element docElement;
			int idDomanda = 1;
	        if(file.exists()) {
	        	
				document = builder.parse(file);
		        docElement = document.getDocumentElement();
		        List<Element> dom = Utils.getChildElements(docElement);
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
	
	
	/*Elimino domanda dal file xml */
	public void deleteDomanda(Domanda domanda) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();

			String id = domanda.getId();
//			List<String> listaPath = Utils.prendiPathIdDomanda(domanda); //			String id = dir + "|" + chapter + "|" + question;
			
//			File file = new File(BASE_DIRECTORY + "\\"+listaPath.get(0)+"\\"+listaPath.get(1)+".xml");
			Document document;
			Element docElement;
//			document = builder.parse(file);
//			docElement = document.getElementById(id);
//			document.removeChild(docElement);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
//		} catch (SAXException e) {
			e.printStackTrace();
//		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	/* SCREMA LISTA DOMANDE IN BASE LIBRO, CAPITOLO O QUESTION */
	public static List<Domanda> domandeLibro(List<Domanda> listaDomande, String libro) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {
			if (d.getId().contains(libro + "|")) {
				lista.add(d);
			}
		}
		return lista;
	}

	public static List<Domanda> domandeCapitolo(List<Domanda> listaDomande, String capitolo) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {
			if (d.getChapter().contains(capitolo)) {
				lista.add(d);
			}
		}
		return lista;
	}

	public static List<Domanda> domandeQuestion(List<Domanda> listaDomande, String question) {
		List<Domanda> lista = new ArrayList<>();
		for (Domanda d : listaDomande) {
			if (String.valueOf(d.getQuestion()).contains(question)) {
				lista.add(d);
			}
		}
		return lista;
	}
	/*-------------------------------------------------------*/
}
