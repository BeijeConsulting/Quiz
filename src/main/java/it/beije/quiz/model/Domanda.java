package it.beije.quiz.model;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Domanda {

	public static final String ANSWER_TYPE_CHECKBOX = "checkbox";
	public static final String ANSWER_TYPE_RADIO = "radio";

	private String id;
	private String book;
	private String chapter;
	private int question;
	private String testo;
	private String answerType;
	private List<Risposta> risposte;
	private String rispostaUtente = "";
	private String rispostaEsatta;
	private String spiegazione;

	public Domanda() {
	}

	public Domanda(String id, String book, String chapter, int question, String testo, String answerType,
			List<Risposta> risposte, String rispostaEsatta, String spiegazione) {
		this.id = id;
		this.book = book;
		this.chapter = chapter;
		this.question = question;
		this.testo = testo;
		this.rispostaEsatta = rispostaEsatta;
		this.answerType = answerType;
		this.risposte = risposte;
		this.spiegazione = spiegazione;
	}

	public String getId() {
		return id;
	}

	public String getChapter() {
		return chapter;
	}

	public String getTesto() {
		return testo;
	}

	public String getRispostaEsatta() {
		return rispostaEsatta;
	}

	public String getSpiegazione() {
		return spiegazione;
	}

	public List<Risposta> getRisposte() {
		return risposte;
	}

	public String getBook() {
		return book;
	}

	public int getQuestion() {
		return question;
	}

	public String getRispostaUtente() {
		return rispostaUtente;
	}

	public void setRispostaUtente(String rispostaUtente) {
		this.rispostaUtente = rispostaUtente;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void editXML(Domanda domanda, String dirLibro, String chapter) {
		// GAB************************************************************************************

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Load the input XML document, parse it and return an instance of the
			// Document class.
			String filePathXML = Libro.LIB_PATH + dirLibro + chapter + ".xml";
			Document document = builder.parse(new File(filePathXML));

			Element docElement = document.getElementById("id"); //select domanda from xml by id.
			
			NodeList listaCampiDomanda = docElement.getChildNodes();

			for (int i = 0; i < listaCampiDomanda.getLength(); i++) {
				
	           Node node = listaCampiDomanda.item(i);

			   if ("testo".equals(node.getNodeName())) {
				node.setTextContent(domanda.getTesto());
			   }
			   if ("risposte".equals(node.getNodeName())) {
				   node.setTextContent(domanda.getTesto());
				   NamedNodeMap listaAttr= node.getAttributes();
				   Node nodeAttrType = listaAttr.getNamedItem("type");
				   nodeAttrType.setTextContent(domanda.getAnswerType());
				   
			   }
			   if ("risposteEsatte".equals(node.getNodeName())) {
				   node.setTextContent(domanda.getRispostaEsatta());
			   }
			   if ("spiegazione".equals(node.getNodeName())) {
				   
				   node.setTextContent(domanda.getSpiegazione());
			   }

			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(filePathXML);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("book : ").append(book).append('\n');
		builder.append("chapter : ").append(chapter).append('\n');
		builder.append("question : ").append(question).append('\n');
		builder.append("testo : ").append(testo).append('\n');
		builder.append("rispostaEsatta : ").append(rispostaEsatta).append('\n');
		builder.append("rispostaUtente : ").append(rispostaUtente).append('\n');
		builder.append("answerType : ").append(answerType).append('\n');
		builder.append("RISPOSTE\n");
		for (Risposta r : risposte) {
			builder.append("  ").append(r.getValue()).append(" - ").append(r.getText()).append('\n');
		}
		builder.append("----------------------------\n");

		return builder.toString();
	}

	public String toJSON() {
		StringBuilder builder = new StringBuilder("{");
		builder.append("\"id\":\"").append(id).append("\",");
		builder.append("\"book\":\"").append(book).append("\",");
		builder.append("\"chapter\":").append(chapter).append(",");
		builder.append("\"question\":").append(question).append(",");
		builder.append("\"testo\":\"").append(testo).append("\",");
		builder.append("\"answerType\":\"").append(answerType).append("\",");
		builder.append("\"risposte\":[");
		for (Risposta r : risposte) {
			builder.append("{\"value\":\"").append(r.getValue()).append("\",");
			builder.append("\"text\":\"").append(r.getText()).append("\"},");
		}
		builder.append("],");
		builder.append("\"rispostaEsatta\":\"").append(rispostaEsatta).append("\",");
		builder.append("\"rispostaUtente\":\"").append(rispostaUtente).append("\",");
		builder.append("\"spiegazione\":\"").append(spiegazione).append("\"");
		builder.append("}");
		return builder.toString();
	}
}
