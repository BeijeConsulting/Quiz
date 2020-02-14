package it.beije.quiz;

import java.util.List;
import java.util.Scanner;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

public class Test {

	private static final String PATH = "C:\\Users\\Padawan09\\git\\Quiz\\domande.xml";
	public static void main(String[] args) {
		List<Domanda> listaDomande = Utils.readFileDomande(PATH);
		Scanner scan = new Scanner(System.in);
		for(Domanda dom : listaDomande) {
			System.out.println(effettuaDomanda(dom));
			dom.setRispostaUtente(scan.nextLine());
		}
		for(Domanda dom : listaDomande) {
			System.out.println(dom);
			if(Utils.controllaRisposta(dom.getRispostaEsatta(), dom.getRispostaUtente())) System.out.println("---------ESATTO---------\n\n");
			else System.out.println("---------ERRATO---------\n\n");
		}
	}
	
	public static String effettuaDomanda(Domanda d) {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(d.getId()).append('\n');
		builder.append("book : ").append(d.getBook()).append('\n');
		builder.append("chapter : ").append(d.getChapter()).append('\n');
		builder.append("question : ").append(d.getQuestion()).append('\n');
		builder.append("testo : ").append(d.getTesto()).append('\n');
		builder.append("answerType : ").append(d.getAnswerType()).append('\n');
		builder.append("RISPOSTE\n");
		List<Risposta> risp = d.getRisposte();
		for (Risposta r : risp) {
			builder.append("  ").append(r.getValue()).append(" - ").append(r.getText()).append('\n');
		}
		builder.append("----------------------------\n");
		
		return builder.toString();
	}
}
