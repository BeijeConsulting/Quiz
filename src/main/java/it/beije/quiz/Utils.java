package it.beije.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.model.Domanda;

public class Utils {

	public static final String BASE_DIRECTORY = "C:\\Users\\" + System.getProperty("user.name")
			+ "\\git\\Quiz\\domande\\";

	/*--------------------------------------*/
	/* General Utils Methods */
	/*--------------------------------------*/
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

	public static int trovaUltimoCapitolo(String dir) { // 5032020___GAB___non è più servito ma potrebbe serivere, trova
														// l'ultimo capitolo xml dentro un dir.

		File file = new File(BASE_DIRECTORY + dir);
		if (file.isDirectory()) {
			File[] lista = file.listFiles();
			for (File f : lista) {
				System.out.println("file dentro dir: " + f);
			}
			if (lista.length == 0) {
				return 0;
			}
			File ultimoFile = lista[lista.length - 1];
			String nameLastFile = ultimoFile.getName();
			nameLastFile = nameLastFile.substring(nameLastFile.indexOf("cap") + 3, nameLastFile.indexOf("."));
			return Integer.parseInt(nameLastFile);
		}

		return 0;
	}

	public static boolean isNumber(String s) { // 5032020___ANDRE___controlla se la stringa è un numero. Sì true No
												// false
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static String getDirectoryFromDomanda(Domanda domanda) {

		String idDom = domanda.getId();
		System.out.println("id domanda:---" + idDom);
		String[] temp = idDom.split(Pattern.quote("|"));
		for(String a : temp) {
			System.out.println("temp:-----" + a);
			System.out.println("\n");
		}
		return temp[0];
	}

	/*--------------------------------------*/

}
