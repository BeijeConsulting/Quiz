package it.beije.quiz.utils;

public class Utils {
	/**
	 * Formatta una Stringa
	 * @param testo String da formattare
	 * @return La String formattata
	 */
	public static String formattaTesto(String testo) {
		if (testo != null && testo.length() > 0) {
			testo = testo.replace("\n", "<br>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		return testo;
	}

	/**
	 * Controlla se la risposta data dall'utente corrisponde alla risposta esatta
	 * @param rispostaEsatta La risposta esatta
	 * @param risposta La risposta dell'user
	 * @return true se rispostaEsatta == risposta
	 */
	public static boolean controllaRisposta(String rispostaEsatta, String risposta) {
		// Rimuovo le virgole dalla risposta esatta e la formatto tutta unita (A, B, C diventa ABC)
		// perché è il formato con cui viene ricevuta la risposta. Senza questa conversione tutte le
		// risposte sono errate
		rispostaEsatta = rispostaEsatta.replace(", ", "");

		for (int i = 0; i < risposta.length(); i++) {
			char c = risposta.charAt(i);
			if (c == ' ' || c == ',') continue;
			if (rispostaEsatta.indexOf(c) < 0) {
				return false; // Se non trovo la risposta termino il ciclo perché sicuro è errata
			} else {
				// Tolgo risposta esatta da elenco risposte esatte per evitare duplicati
				rispostaEsatta = rispostaEsatta.replace(Character.toString(c), "");
			}
		}
		return rispostaEsatta.length() == 0;
	}
}