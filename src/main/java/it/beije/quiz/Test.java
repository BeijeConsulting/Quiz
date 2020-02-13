package it.beije.quiz;

import java.util.List;
import java.util.Scanner;

import it.beije.quiz.model.Domanda;

public class Test {

	private static final String PATH = "C:\\Users\\Padawan09\\git\\Quiz\\domande.xml";
	public static void main(String[] args) {
		List<Domanda> listaDomande = Utils.readFileDomande(PATH);
		Scanner scan = new Scanner(System.in);
		for(Domanda dom : listaDomande) {
			System.out.println(dom.effettuaDomanda());
			dom.setRispostaUtente(scan.nextLine());
		}
		for(Domanda dom : listaDomande) {
			System.out.println(dom);
			if(Utils.controllaRisposta(dom.getRispostaEsatta(), dom.getRispostaUtente())) System.out.println("---------ESATTO---------\n\n");
			else System.out.println("---------ERRATO---------\n\n");
		}
	}
}
